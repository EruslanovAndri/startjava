package com.startjava.lesson_2_3_4.bookcase.exception;

public class InvalidYearException extends RuntimeException {
    public InvalidYearException(String message) {
        super(message);
    }
}
