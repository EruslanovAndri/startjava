package com.startjava.lesson_2_3_4.bookcase.exception;

public class NotFoundBookTitle extends RuntimeException {
    public NotFoundBookTitle(String message) {
        super(message);
    }
}
