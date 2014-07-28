package co.edu.udea.compumovil.ahorcatooth.persistence.exception;

import android.util.Log;

public class AhorcaToothPersistenceException extends Exception {

	private static final long serialVersionUID = 4453218535679452873L;
	private static final String TAG = AhorcaToothPersistenceException.class
			.getSimpleName();

	public AhorcaToothPersistenceException() {
		super();

		Log.e(TAG, super.getMessage());
	}

	public AhorcaToothPersistenceException(String detailMessage) {
		super(detailMessage);

		Log.e(TAG, detailMessage);
	}

	public AhorcaToothPersistenceException(Throwable throwable) {
		super(throwable);

		Log.e(TAG, super.getMessage(), throwable);
	}

	public AhorcaToothPersistenceException(String detailMessage,
			Throwable throwable) {
		super(detailMessage, throwable);

		Log.e(TAG, detailMessage, throwable);
	}
}