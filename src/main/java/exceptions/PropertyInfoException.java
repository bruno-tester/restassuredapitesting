package exceptions;

public class PropertyInfoException extends RuntimeException {
    public PropertyInfoException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
