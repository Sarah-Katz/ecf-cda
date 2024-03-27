package co.simplon.sarah.api.ecf.business.convert;

/**
 * Exception thrown when an error occurs during the conversion process, either
 * due to a mismatch of getter/setter methods or the constructor of the output
 * class
 */
public class GenericConverterException extends Exception {
    public GenericConverterException() {
    }

    public GenericConverterException(final String message, final Exception e) {
        super(message, e);
    }
}
