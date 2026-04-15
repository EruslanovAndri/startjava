package com.startjava.lesson_2_3_4.calculator;



public class InvalidSingException extends RuntimeException {
    public InvalidSingException() {
    }
    public InvalidSingException(String message) {
        super(message);
    }
}
