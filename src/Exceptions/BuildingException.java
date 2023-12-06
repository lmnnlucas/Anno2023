package Exceptions;

public class BuildingException extends RuntimeException{
    public BuildingException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuildingException(String message) {
        super(message);
    }
}
