package Exceptions;

/**
 * Exception thrown when an error occurs in the Building class or linked methods
 */
public class BuildingException extends RuntimeException{

    /**
     * Constructor for BuildingException
     * @param message Message that will be shown when the exception is thrown
     * @param cause Cause of the exception
     */
    public BuildingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor for BuildingException
     * @param message Message that will be shown when the exception is thrown
     */
    public BuildingException(String message) {
        super(message);
    }
}
