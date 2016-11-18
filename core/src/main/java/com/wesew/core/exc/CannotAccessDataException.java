package com.wesew.core.exc;

/**
 * @author vladyslav.yemelianov
 */
public class CannotAccessDataException extends WeSeWRuntimeException {

    public CannotAccessDataException() {
    }

    public CannotAccessDataException(String message) {
        super(message);
    }

    public CannotAccessDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public CannotAccessDataException(Throwable cause) {
        super(cause);
    }
}
