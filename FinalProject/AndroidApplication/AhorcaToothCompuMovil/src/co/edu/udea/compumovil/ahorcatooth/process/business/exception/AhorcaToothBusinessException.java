package co.edu.udea.compumovil.ahorcatooth.process.business.exception;

public class AhorcaToothBusinessException extends Exception {

	private static final long serialVersionUID = -5998087575400863908L;

	public AhorcaToothBusinessException() {
		super();
	}

	public AhorcaToothBusinessException(String detailMessage) {
		super(detailMessage);
	}

	public AhorcaToothBusinessException(Throwable throwable) {
		super(throwable);
	}

	public AhorcaToothBusinessException(String detailMessage,
			Throwable throwable) {
		super(detailMessage, throwable);
	}
}