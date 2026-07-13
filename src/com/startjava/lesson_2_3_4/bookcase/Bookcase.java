package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.BookNotExistException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookcaseOverflowException;
import java.util.Arrays;

public class Bookcase {
    public static final int CAPACITY = 10;
    private static final int MAX_INDENT = 6;
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

    public void setCounter() {
        counter = 0;
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
        for (int i = 0; i < bookCounter; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                findBook[i] = books[i];
                counter++;
            } else {
                throw new BookNotExistException("Такой книги нет на полке.");
            }
        }
        return findBook;
    }

    public int removeBookByTitle(String title) {
        int i = 0;
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
            throw new BookNotExistException("Такой книги нет на полке.");
        }
        return counter;
    }

    public void getAllBooks() {
        for (int i = 0; i < bookCounter; i++) {
            System.out.println(books[i]);
            System.out.println("|" + "-".repeat(getMaxBookLengthName() + MAX_INDENT) + "|");
        }
    }

    public void clearBookcase() {
        Arrays.fill(books, 0, bookCounter, null);
        bookCounter = 0;
    }

    private int getMaxBookLengthName() {
        int maxLength = books[0].getAuthor().length() + books[0].getTitle().length() +
                books[0].getReleaseYear().toString().length();
        for (int i = 0; i < bookCounter; i++) {
            if (maxLength < books[i].getAuthor().length() + books[i].getTitle().length() +
                    books[i].getReleaseYear().toString().length()) {
                maxLength = books[i].getAuthor().length() + books[i].getTitle().length() +
                        books[i].getReleaseYear().toString().length();
            }
        }
        return maxLength;
    }
}
