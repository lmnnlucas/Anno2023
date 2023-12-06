package Exceptions;

/**
 * Exception thrown when an error occurs in the UI class or linked methods.
 * Especially when the user enters a wrong value or its input misses some information
 */
public class WrongEntryException extends RuntimeException {
    public WrongEntryException(String message, Throwable err) {
        super(message, err);
    }

    public WrongEntryException(String message) {
        super(message);
    }

}
