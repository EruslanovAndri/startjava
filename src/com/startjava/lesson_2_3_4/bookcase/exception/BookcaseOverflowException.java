package com.startjava.lesson_2_3_4.bookcase.exception;

public class BookcaseOverflowException extends RuntimeException {
    public BookcaseOverflowException(String message) {
        super(message);
    }
}
