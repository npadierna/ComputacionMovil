package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import java.util.List;

import android.content.Context;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.webservice.ICategoryWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;

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

	@Override()
	public List<Category> findAll() throws AhorcaToothWebServiceException {
		Log.i(TAG, "findAll():List<Category>");

		return (null);
	}

	@Override()
	public List<Category> findByLanguagesIsoCode(String languesIsoCode)
			throws AhorcaToothWebServiceException {
		Log.i(TAG, "findByLanguagesIsoCode():List<Category>");

		return (null);
	}
}