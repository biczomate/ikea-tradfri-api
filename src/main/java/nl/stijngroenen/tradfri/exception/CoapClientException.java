package nl.stijngroenen.tradfri.exception;

/**
 * Contains details about issues with Coap communication
 *
 * @author Máté Biczó
 * @version 1.3.0
 */
public class CoapClientException extends RuntimeException {
    /**
     * Construct a new CoapClientException
     *
     * @param cause The cause of an exception
     */
    public CoapClientException(Throwable cause) {
        super(cause);
    }

    public CoapClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoapClientException(String message) {
        super(message);
    }
}
