package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.BookNotExistException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookcaseOverflowException;
import java.util.Arrays;

public class Bookcase {
    public static final int CAPACITY = 10;
    private static int bookCounter;
    private Book[] books;
    private int counter;
    public int bookcaseLength;

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

    public Book[] findBooks(String title) {
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

    public int removeBooks(String title) {
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
        findBookcaseLength();
        Book[] books = Arrays.copyOf(this.books, bookCounter);
        return books;
    }

    public void clearBookcase() {
        Arrays.fill(books, 0, bookCounter, null);
        bookCounter = 0;
    }

    private void findBookcaseLength() {
        for (int i = 0; i < bookCounter; i++) {
            bookcaseLength = Math.max(bookcaseLength, books[i].toString().length());
        }
    }
}
