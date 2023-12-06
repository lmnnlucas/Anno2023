package Exceptions;

public class NoBuildingAtPosException extends RuntimeException {
    public NoBuildingAtPosException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoBuildingAtPosException(String message) {
        super(message);
    }
}
