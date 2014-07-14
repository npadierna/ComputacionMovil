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
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.webservice.ICategoryWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;
import co.edu.udea.compumovil.ahorcatooth.webservice.restful.contract.WebServicePathsContract;

public class CategoryWSImpl extends AbstractContextWS implements ICategoryWS {

	private static final String TAG = CategoryWSImpl.class.getSimpleName();

	private static CategoryWSImpl instance;

	private CategoryWSImpl(Context context) {
		super(context);
	}

	public static synchronized CategoryWSImpl getInstance(Context context) {
		if (instance == null) {
			instance = new CategoryWSImpl(context);
		}

		return (instance);
	}

	private List<Category> convertJSONArrayToCategoriesList(JSONArray jsonArray)
			throws JSONException {
		List<Category> categoriesFoundList = new ArrayList<Category>();

		for (int index = 0; index < jsonArray.length(); index++) {
			categoriesFoundList
					.add(new Category(jsonArray.getJSONObject(index)));
		}

		return (categoriesFoundList);
	}

	@Override()
	public List<Category> findAll() throws AhorcaToothWebServiceException {
		Log.i(TAG, "findAll():List<Category>");

		try {
			HttpGet httpGet = new HttpGet();
			HttpEntity httpEntity = super
					.executeHTTPMethod(
							new String[] {
									WebServicePathsContract.CategoryContract.ROOT_PATH,
									WebServicePathsContract.CategoryContract.FIND_ALL_CATEGORIES_PATH },
							null, httpGet);

			if (httpEntity != null) {
				String response = EntityUtils.toString(httpEntity);

				return (this.convertJSONArrayToCategoriesList(new JSONArray(
						super.formatToJSONArrayString(response))));
			}

			return (null);
		} catch (Exception e) {
			throw new AhorcaToothWebServiceException(String.format(
					"Error while procedure: \"%s\" was in execution.",
					"findAll():List<Languages>"), e);
		}
	}

	@Override()
	public List<Category> findByLanguagesIsoCode(String languesIsoCode)
			throws AhorcaToothWebServiceException {
		Log.i(TAG, "findByLanguagesIsoCode(String):List<Category>");

		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap
				.put(WebServicePathsContract.CategoryContract.LANGUAGES_ISO_CODE_QUERY,
						languesIsoCode);

		try {
			HttpGet httpGet = new HttpGet();
			HttpEntity httpEntity = super
					.executeHTTPMethod(
							new String[] {
									WebServicePathsContract.CategoryContract.ROOT_PATH,
									WebServicePathsContract.CategoryContract.FIND_CATEGORIES_BY_LANGUAGES_ISO_CODE_PATH },
							parametersMap, httpGet);

			if (httpEntity != null) {
				String response = EntityUtils.toString(httpEntity);

				return (this.convertJSONArrayToCategoriesList(new JSONArray(
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