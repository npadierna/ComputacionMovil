package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.webservice.IHangmanWordWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;
import co.edu.udea.compumovil.ahorcatooth.webservice.restful.contract.WebServicePathsContract;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class HangmanWordWSImpl extends AbstractContextWS implements
		IHangmanWordWS {

	private static final String TAG = HangmanWordWSImpl.class.getSimpleName();

	private static HangmanWordWSImpl instance;

	private HangmanWordWSImpl(Context context) {
		super(context);
	}

	public static synchronized HangmanWordWSImpl getInstance(Context context) {
		if (instance == null) {
			instance = new HangmanWordWSImpl(context);
		}

		return (instance);
	}

	private List<HangmanWord> convertJSONArrayToHangmansWordsList(
			JSONArray jsonArray) throws JSONException {
		List<HangmanWord> hangmansWordsFoundList = new ArrayList<HangmanWord>();

		for (int index = 0; index < jsonArray.length(); index++) {
			hangmansWordsFoundList.add(new HangmanWord(jsonArray
					.getJSONObject(index)));
		}

		return (hangmansWordsFoundList);
	}

	@Override()
	public List<HangmanWord> findLatestWithLimit(String categoryName,
			String languageIsoCode, Integer limit)
			throws AhorcaToothWebServiceException {
		Log.i(TAG,
				"findLatestWithLimit(String, String, Integer):List<HangmanWord>");

		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap
				.put(WebServicePathsContract.HangmanWordContract.CATEGORY_NAME_QUERY,
						categoryName);
		parametersMap
				.put(WebServicePathsContract.HangmanWordContract.LANGUAGES_ISO_CODE_QUERY,
						languageIsoCode);
		parametersMap
				.put(WebServicePathsContract.HangmanWordContract.LIMIT_HANGMANS_WORDS_QUERY,
						limit);

		try {
			HttpGet httpGet = new HttpGet();
			HttpEntity httpEntity = super
					.executeHTTPMethod(
							new String[] {
									WebServicePathsContract.HangmanWordContract.ROOT_PATH,
									WebServicePathsContract.HangmanWordContract.FIND_LASTEST_HANGMANS_WORDS_PATH },
							parametersMap, httpGet);

			if (httpEntity != null) {
				String response = EntityUtils.toString(httpEntity);

				return (this.convertJSONArrayToHangmansWordsList(new JSONArray(
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