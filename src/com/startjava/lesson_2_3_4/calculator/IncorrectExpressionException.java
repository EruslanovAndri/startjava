package com.startjava.lesson_2_3_4.calculator;

public class IncorrectExpressionException extends RuntimeException {
    public IncorrectExpressionException(final String message) {
        super(message);
    }
}
