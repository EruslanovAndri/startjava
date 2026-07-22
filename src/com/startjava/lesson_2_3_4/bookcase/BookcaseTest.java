package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.ExitException;

public class BookcaseTest {
    public static void main(String[] args) {
        BookcaseHandler bookcaseHandler = new BookcaseHandler();
        boolean running = true;
        while (running) {
            try {
                bookcaseHandler.run();
            } catch (ExitException e) {
                System.out.println(e.getMessage());
                running = false;
            }
        }
    }
}
