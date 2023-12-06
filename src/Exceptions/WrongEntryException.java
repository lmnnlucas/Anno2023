package Exceptions;

public class WrongEntryException extends RuntimeException {
    public WrongEntryException(String message, Throwable err) {
        super(message, err);
    }

    public WrongEntryException(String message) {
        super(message);
    }

}
