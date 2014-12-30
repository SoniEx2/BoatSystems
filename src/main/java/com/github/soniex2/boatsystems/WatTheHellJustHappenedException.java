package com.github.soniex2.boatsystems;

/**
 * WAT?!
 *
 * @author soniex2
 */
public class WatTheHellJustHappenedException extends RuntimeException {
    public WatTheHellJustHappenedException() {
    }

    public WatTheHellJustHappenedException(String message) {
        super(message);
    }

    public WatTheHellJustHappenedException(String message, Throwable cause) {
        super(message, cause);
    }

    public WatTheHellJustHappenedException(Throwable cause) {
        super(cause);
    }

    public WatTheHellJustHappenedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
