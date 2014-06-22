package co.edu.udea.compumovil.ahorcatooth.persistance.exception;

import java.io.Serializable;

public class AhorcaToothDatabaseException extends Exception
        implements Serializable {

    private static final long serialVersionUID = 7614433027969649664L;

    public AhorcaToothDatabaseException() {
        super();
    }

    public AhorcaToothDatabaseException(String message) {
        super(message);
    }

    public AhorcaToothDatabaseException(Throwable cause) {
        super(cause);
    }

    public AhorcaToothDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}