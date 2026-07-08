package com.startjava.lesson_2_3_4.bookcase.exception;

public class ZeroQuantityException extends RuntimeException {
    public ZeroQuantityException(String message) {
        super(message);
    }
}
