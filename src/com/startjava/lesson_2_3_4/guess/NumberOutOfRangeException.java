package com.startjava.lesson_2_3_4.guess;

public class NumberOutOfRangeException extends RuntimeException {
    public NumberOutOfRangeException(final String message) {
        super(message);
    }
}
