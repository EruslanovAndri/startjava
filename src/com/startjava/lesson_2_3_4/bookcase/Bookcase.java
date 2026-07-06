package com.startjava.lesson_2_3_4.bookcase;

import java.util.Arrays;

public class Bookcase {
    private static final int MAX_BOOK_QUANTITY = 10;
    private static int bookCounter;
    private Book[] books;

    public Bookcase() {
        books = new Book[MAX_BOOK_QUANTITY];
    }

    public int getMaxBookQuantity() {
        return MAX_BOOK_QUANTITY;
    }

    public int getBookCounter() {
        return bookCounter;
    }

    public void addBook(Book book) {
        if (bookCounter == MAX_BOOK_QUANTITY) {
            throw new StackOverflowError("На полке закончилось свободное место.");
        }
        if (bookCounter < MAX_BOOK_QUANTITY) {
            books[bookCounter] = book;
            bookCounter++;
        }
    }

    public Book findBookByTitle(String title) {
        int index = -1;
        for (int i = 0; i < bookCounter; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                index = i;
            }
        }
        if (index == -1) {
            throw new ArrayIndexOutOfBoundsException("Книги с таким названием нет на полке.");
        }
        return books[index];
    }

    public void removeBookByTitle(String title) {
        int bookIndex = 0;
        for (int i = 0; i < bookCounter; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                bookIndex = i;
                bookCounter--;
            }
        }
        Book[] booksCopy = Arrays.copyOf(books, books.length - 1);
        for (int i = 0, j = 0; i < books.length; i++) {
            if (i == bookIndex) {
                continue;
            } else {
                booksCopy[j++] = books[i];
            }
        }
        books = Arrays.copyOf(booksCopy, MAX_BOOK_QUANTITY);
    }

    public void getAllBooks() {
        for (int i = 0; i < bookCounter; i++) {
            System.out.println(books[i]);
            System.out.println("-".repeat(30));
        }
    }

    public void clearBookcase() {
        for (int i = 0; i < bookCounter; i++) {
            books[i] = null;
        }
        bookCounter = 0;
    }

    public void close(String message) {
        System.out.println(message);
        System.exit(0);
    }
}
