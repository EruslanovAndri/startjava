package com.startjava.lesson_2_3_4.bookcase;

public class BookcaseTest {
    public static void main(String[] args) {
        BookcaseHandler bookcaseHandler = new BookcaseHandler();
        boolean running = true;
        while (running) {
            running = bookcaseHandler.run();
        }
    }
}
