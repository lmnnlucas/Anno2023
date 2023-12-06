package Exceptions;

/**
 * Exception thrown when an error occurs in the Building class or linked methods
 */
public class BuildingException extends RuntimeException{
    public BuildingException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuildingException(String message) {
        super(message);
    }
}
