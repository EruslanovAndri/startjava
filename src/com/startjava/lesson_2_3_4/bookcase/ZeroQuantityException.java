package com.startjava.lesson_2_3_4.bookcase;

public class ZeroQuantityException extends RuntimeException {
    public ZeroQuantityException(String message) {
        super(message);
    }
}
