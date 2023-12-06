package Exceptions;

/**
 * Exception thrown when an error occurs in the UI class or linked methods.
 * Especially when the user enters a wrong value or its input misses some information
 */
public class WrongEntryException extends RuntimeException {

    /**
     * Constructor for WrongEntryException
     * @param message Message that will be shown when the exception is thrown
     * @param err Cause of the exception
     */
    public WrongEntryException(String message, Throwable err) {
        super(message, err);
    }

    /**
     * Constructor for WrongEntryException
     * @param message Message that will be shown when the exception is thrown
     */
    public WrongEntryException(String message) {
        super(message);
    }

}
