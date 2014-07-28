package co.edu.udea.compumovil.ahorcatooth.webservice.exception;

import android.util.Log;

public class AhorcaToothWebServiceException extends Exception {

	private static final long serialVersionUID = 204215715359640858L;
	private static final String TAG = AhorcaToothWebServiceException.class
			.getSimpleName();

	public AhorcaToothWebServiceException() {
		super();

		Log.e(TAG, super.getMessage());
	}

	public AhorcaToothWebServiceException(String detailMessage) {
		super(detailMessage);

		Log.e(TAG, detailMessage);
	}

	public AhorcaToothWebServiceException(Throwable throwable) {
		super(throwable);

		Log.e(TAG, super.getMessage(), throwable);
	}

	public AhorcaToothWebServiceException(String detailMessage,
			Throwable throwable) {
		super(detailMessage, throwable);

		Log.e(TAG, detailMessage, throwable);
	}
}