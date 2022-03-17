package exceptions;

public class ConfigurationReaderFileException extends RuntimeException {
    public ConfigurationReaderFileException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}