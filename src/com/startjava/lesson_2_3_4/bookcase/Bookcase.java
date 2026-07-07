package com.startjava.lesson_2_3_4.bookcase;

public class Bookcase {
    private static final int MAX_BOOK_QUANTITY = 10;
    private static final int MAX_INDENT = 6;
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
        if (bookCounter < MAX_BOOK_QUANTITY) {
            books[bookCounter] = book;
            bookCounter++;
        }
    }

    // Нужно доработать поиск более одной книги и их вывод!!!

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

    public int removeBookByTitle(String title) {
        int i = 0;
        int counter = 0;
        while (i < bookCounter) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                System.arraycopy(books, i + 1, books, i, books.length - i - 1);
                counter++;
                bookCounter--;
            } else {
                i++;
            }
        }
        if (counter == 0) {
            throw new NotFoundBookTitle("Такой книги нет на полке.");
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
        for (int i = 0; i < bookCounter; i++) {
            books[i] = null;
        }
        bookCounter = 0;
    }

    public void close(String message) {
        System.out.println(message);
        System.exit(0);
    }

    private int getMaxBookLengthName() {
        int maxLength = books[0].getAuthor().length() + books[0].getTitle().length() +
                books[0].getYear().toString().length();
        for (int i = 0; i < bookCounter; i++) {
            if (maxLength < books[i].getAuthor().length() + books[i].getTitle().length() +
                    books[i].getYear().toString().length()) {
                maxLength = books[i].getAuthor().length() + books[i].getTitle().length() +
                        books[i].getYear().toString().length();
            }
        }
        return maxLength;
    }
}
