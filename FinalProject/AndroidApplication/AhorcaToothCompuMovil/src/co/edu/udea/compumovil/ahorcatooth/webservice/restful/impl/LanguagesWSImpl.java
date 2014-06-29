package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import java.util.List;

import android.content.Context;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.webservice.ILanguagesWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;

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

	@Override()
	public List<Languages> findAll() throws AhorcaToothWebServiceException {
		Log.i(TAG, "findAll():List<Languages>");

		return (null);
	}
}