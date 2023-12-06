package Exceptions;

/**
 * Exception that is thrown when an error related to a citizen occurs
 */
public class CitizenException extends RuntimeException{

    /**
     * Constructor for CitizenException
     * @param message Message that will be shown when the exception is thrown
     */
    public CitizenException(String message){
        super(message);
    }

    /**
     * Constructor for CitizenException
     * @param message Message that will be shown when the exception is thrown
     * @param cause Cause of the exception
     */
    public CitizenException(String message, Throwable cause){
        super(message, cause);
    }
}
