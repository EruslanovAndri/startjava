package com.startjava.lesson_2_3_4.bookcase.exception;

public class NoMoreSpaceException extends RuntimeException {
    public NoMoreSpaceException(String message) {
        super(message);
    }
}
