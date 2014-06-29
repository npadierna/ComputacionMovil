package co.edu.udea.compumovil.ahorcatooth.webservice.restful.impl;

import java.util.List;

import android.content.Context;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.webservice.IHangmanWordWS;
import co.edu.udea.compumovil.ahorcatooth.webservice.exception.AhorcaToothWebServiceException;

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

	@Override()
	public List<HangmanWord> findLatestWithLimit(String categoryName,
			String languageIsoCode, Integer limit)
			throws AhorcaToothWebServiceException {
		Log.i(TAG,
				"findLatestWithLimit(String, String, Integer):List<HangmanWord>");

		return (null);
	}
}