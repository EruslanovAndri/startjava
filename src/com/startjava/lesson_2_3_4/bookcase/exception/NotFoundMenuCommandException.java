package com.startjava.lesson_2_3_4.bookcase.exception;

public class NotFoundMenuCommandException extends RuntimeException {
    public NotFoundMenuCommandException(String message) {
        super(message);
    }
}
