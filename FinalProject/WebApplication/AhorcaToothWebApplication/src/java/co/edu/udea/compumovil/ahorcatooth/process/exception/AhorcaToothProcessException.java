package co.edu.udea.compumovil.ahorcatooth.process.exception;

import java.io.Serializable;

public class AhorcaToothProcessException extends Exception
        implements Serializable {

    private static final long serialVersionUID = 7614433027969649664L;

    public AhorcaToothProcessException() {
        super();
    }

    public AhorcaToothProcessException(String message) {
        super(message);
    }

    public AhorcaToothProcessException(Throwable cause) {
        super(cause);
    }

    public AhorcaToothProcessException(String message, Throwable cause) {
        super(message, cause);
    }
}