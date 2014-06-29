package co.edu.udea.compumovil.ahorcatooth.persistence.exception;

public class AhorcaToothPersistenceException extends Exception {

	private static final long serialVersionUID = 4453218535679452873L;

	public AhorcaToothPersistenceException() {
		super();
	}

	public AhorcaToothPersistenceException(String detailMessage) {
		super(detailMessage);
	}

	public AhorcaToothPersistenceException(Throwable throwable) {
		super(throwable);
	}

	public AhorcaToothPersistenceException(String detailMessage,
			Throwable throwable) {
		super(detailMessage, throwable);
	}
}