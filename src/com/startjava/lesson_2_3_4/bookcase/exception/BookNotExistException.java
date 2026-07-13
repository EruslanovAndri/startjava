package com.startjava.lesson_2_3_4.bookcase.exception;

public class BookNotExistException extends RuntimeException {
    public BookNotExistException(String message) {
        super(message);
    }
}
