package com.startjava.lesson_2_3_4.guess;

public class NumberOutOfRangeException extends RuntimeException{
    public NumberOutOfRangeException() {
    }

    public NumberOutOfRangeException(final String message) {
        super(message);
    }

    public NumberOutOfRangeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NumberOutOfRangeException(final Throwable cause) {
        super(cause);
    }

    public NumberOutOfRangeException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
