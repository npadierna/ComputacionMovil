package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.webservice.ILanguagesWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;
import co.edu.udea.compumovil.ahorcatooth.webservice.restful.contract.WebServicePathsContract;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class LanguagesWSImpl extends AbstractContextWS implements ILanguagesWS {

	private static final String TAG = LanguagesWSImpl.class.getSimpleName();

	private static LanguagesWSImpl instance;

	private LanguagesWSImpl(Context context) {
		super(context);
	}

	public static synchronized LanguagesWSImpl getInstance(Context context) {
		if (instance == null) {
			instance = new LanguagesWSImpl(context);
		}

		return (instance);
	}

	private List<Languages> convertJSONArrayToLanguagesList(JSONArray jsonArray)
			throws JSONException {
		List<Languages> languagesFoundList = new ArrayList<Languages>();

		for (int index = 0; index < jsonArray.length(); index++) {
			languagesFoundList
					.add(new Languages(jsonArray.getJSONObject(index)));
		}

		return (languagesFoundList);
	}

	@Override()
	public List<Languages> findAll() throws AhorcaToothWebServiceException {
		Log.i(TAG, "findAll():List<Languages>");

		try {
			HttpGet httpGet = new HttpGet();
			HttpEntity httpEntity = super
					.executeHTTPMethod(
							new String[] {
									WebServicePathsContract.LanguagesContract.ROOT_PATH,
									WebServicePathsContract.LanguagesContract.FIND_ALL_LANGUAGES_PATH },
							null, httpGet);

			if (httpEntity != null) {
				String response = EntityUtils.toString(httpEntity);

				return (this.convertJSONArrayToLanguagesList(new JSONArray(
						super.formatToJSONArrayString(response))));
			}

			return (null);
		} catch (Exception e) {
			throw new AhorcaToothWebServiceException(String.format(
					"Error while procedure: \"%s\" was in execution.",
					"findAll():List<Languages>"), e);
		}
	}
}