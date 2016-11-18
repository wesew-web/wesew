package com.wesew.core.exc;

/**
 * @author vladyslav.yemelianov
 */
public class ImageNotFoundException extends WeSeWRuntimeException {

    public ImageNotFoundException() {
    }

    public ImageNotFoundException(String message) {
        super(message);
    }

    public ImageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImageNotFoundException(Throwable cause) {
        super(cause);
    }
}
