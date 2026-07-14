package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.BookNotExistException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookcaseOverflowException;
import java.util.Arrays;

public class Bookcase {
    public static final int CAPACITY = 10;
    private static int bookCounter;
    private Book[] books;
    private int counter;

    public Bookcase() {
        books = new Book[CAPACITY];
    }

    public int getBookCounter() {
        return bookCounter;
    }

    public int getCounter() {
        return counter;
    }

    public void addBook(Book book) {
        if (bookCounter == CAPACITY) {
            throw new BookcaseOverflowException("В шкафу закончилось свободное место.");
        }
        books[bookCounter] = book;
        bookCounter++;
    }

    public Book[] foundBooks(String title) {
        Book[] findBook = new Book[bookCounter];
        counter = 0;
        for (int i = 0; i < bookCounter; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                findBook[i] = books[i];
                counter++;
            }
        }
        if (counter == 0) {
            throw new BookNotExistException("Книги с таким названием нет на полке.");
        }
        return findBook;
    }

    public int removeBookByTitle(String title) {
        int i = 0;
        counter = 0;
        while (i < bookCounter) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                System.arraycopy(books, i + 1, books, i, bookCounter - i - 1);
                counter++;
                bookCounter--;
            } else {
                i++;
            }
        }
        if (counter == 0) {
            throw new BookNotExistException("Книгу невозможно удалить, такой книги нет на полке.");
        }
        return counter;
    }

    public Book[] getAllBooks() {
        Book[] tmp = new Book[bookCounter];
        for (int i = 0; i < bookCounter; i++) {
            if (books[i] != null) {
                tmp[i] = books[i];
            }
        }
        return tmp;
    }

    public void clearBookcase() {
        Arrays.fill(books, 0, bookCounter, null);
        bookCounter = 0;
    }
}
