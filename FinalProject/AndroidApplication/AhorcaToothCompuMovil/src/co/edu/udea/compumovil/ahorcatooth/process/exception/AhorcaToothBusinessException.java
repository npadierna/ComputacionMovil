package co.edu.udea.compumovil.ahorcatooth.process.exception;

import android.util.Log;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class AhorcaToothBusinessException extends Exception {

	private static final long serialVersionUID = -5998087575400863908L;
	private static final String TAG = AhorcaToothBusinessException.class
			.getSimpleName();

	public AhorcaToothBusinessException() {
		super();

		Log.e(TAG, super.getMessage());
	}

	public AhorcaToothBusinessException(String detailMessage) {
		super(detailMessage);

		Log.e(TAG, detailMessage);
	}

	public AhorcaToothBusinessException(Throwable throwable) {
		super(throwable);

		Log.e(TAG, super.getMessage(), throwable);
	}

	public AhorcaToothBusinessException(String detailMessage,
			Throwable throwable) {
		super(detailMessage, throwable);

		Log.e(TAG, detailMessage, throwable);
	}
}