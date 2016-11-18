package com.wesew.core.exc;

/**
 * @author vladyslav.yemelianov
 */
public class WeSeWRuntimeException extends RuntimeException {

    public WeSeWRuntimeException() {
    }

    public WeSeWRuntimeException(String message) {
        super(message);
    }

    public WeSeWRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeSeWRuntimeException(Throwable cause) {
        super(cause);
    }

}
