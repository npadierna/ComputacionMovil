package co.edu.udea.compumovil.ahorcatooth.webservice.exception;

public class AhorcaToothWebServiceException extends Exception {

	private static final long serialVersionUID = 204215715359640858L;

	public AhorcaToothWebServiceException() {
		super();
	}

	public AhorcaToothWebServiceException(String detailMessage) {
		super(detailMessage);
	}

	public AhorcaToothWebServiceException(Throwable throwable) {
		super(throwable);
	}

	public AhorcaToothWebServiceException(String detailMessage,
			Throwable throwable) {
		super(detailMessage, throwable);
	}
}