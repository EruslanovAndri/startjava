package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.BookNotExistException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookcaseOverflowException;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookcaseHandler {
    private static final int START_MENU_RANGE = 1;
    private static final int END_MENU_RANGE = 5;
    private static final int SPEED = 50;
    private static final int MAX_INDENT = 6;
    private Scanner scanner;
    private Bookcase bookcase;

    public BookcaseHandler() {
        bookcase = new Bookcase();
        scanner = new Scanner(System.in);
    }

    public void run() {
//        if (bookcase.getBookCounter() == 0) {
//            typeWelcomeMessage();
//        }
        printMenu();
        Menu inputCommand = Menu.chooseOption(inputCommand());
        try {
            switch (inputCommand) {
                case ADD -> bookcase.addBook(addDescription());
                case FIND -> {
                    System.out.print("Введите название искомой книги - ");
                    String title = scanner.nextLine();
                    Book[] foundBook = bookcase.foundBooksByTitle(title);
                    System.out.println("Найдено книг " + bookcase.getCounter());
                    showFoundBook(foundBook);
                }
                case REMOVE -> {
                    System.out.print("Введите название книги для удаления - ");
                    String title = scanner.nextLine();
                    bookcase.removeBookByTitle(title);
                    System.out.println("Удалено книг: " + bookcase.getCounter());
                }
                case CLEAR -> bookcase.clearBookcase();
                case CLOSE -> System.exit(0);
                default -> scanner.nextLine();
            }
            if (pressedEnter()) {
                System.out.printf("""
                            В шкафу %d книг, свободных мест %d
                            """,
                        bookcase.getBookCounter(),
                        bookcase.CAPACITY - bookcase.getBookCounter());
            }
        } catch (IllegalArgumentException | BookcaseOverflowException |
                 BookNotExistException e) {
            System.out.println(e.getMessage());
        }
        printBookcase();
    }

    private void typeWelcomeMessage() {
        String welcomeMessage = "Программа <<Книжная полка>> приветствует вас!\n";
        for (int i = 0; i < welcomeMessage.length(); i++) {
            System.out.print(welcomeMessage.charAt(i));
            try {
                Thread.sleep(SPEED);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }

    private void printMenu() {
        int ordinalNumber = 1;
        for (Menu menu : Menu.createMenu(bookcase.getBookCounter(),
                bookcase.CAPACITY)) {
            System.out.println(ordinalNumber++  + ": " + menu.getDescription());
        }
    }

    private int inputCommand() {
        int command = 0;
        boolean accepted = true;
        while (accepted) {
            try {
                System.out.print("Введите команду - ");
                if (scanner.hasNextInt()) {
                    command = scanner.nextInt();
                } else {
                    throw new InputMismatchException("Ошибка: Необходимо ввести целое число.");
                }

                if (command >= START_MENU_RANGE && command <= END_MENU_RANGE) {
                    accepted = false;
                } else {
                    throw new IndexOutOfBoundsException("Ошибка: Неверное значение меню (" +
                            command + ") " +
                            "Допустимые значения " + START_MENU_RANGE + " - " + END_MENU_RANGE);
                }
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            scanner.nextLine();
            if (bookcase.getBookCounter() == bookcase.CAPACITY) {
                command++;
            } else if (bookcase.getBookCounter() == 0 && command == 2) {
                command += 3;
            }
        }
        return command;
    }

    private Book addDescription() {
        System.out.println("Добавление новой книги");
        while (true) {
            System.out.print("Фамилия автора - ");
            String author = scanner.nextLine();
            System.out.print("Название книги - ");
            String title = scanner.nextLine();
            try {
                System.out.print("Год издания - ");
                Year year = Year.of(scanner.nextInt());
                scanner.nextLine();
                return new Book(author, title, year);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean pressedEnter() {
        System.out.print("Для продолжения работы нажмите <Enter>");
        String enter = scanner.nextLine();
        if (!enter.isEmpty()) {
            pressedEnter();
        }
        return true;
    }

    private void printBookcase() {
        Book[] books = bookcase.getAllBooks();
        for (Book book : books) {
            System.out.println(book.toString());
            System.out.println("|" + "-".repeat(getMaxBookLengthName(books) + MAX_INDENT) + "|");
        }

    }

    private void showFoundBook(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println(books[i].toString());
            }
        }
    }

    private int getMaxBookLengthName(Book[] books) {
        int maxLength = books[0].getAuthor().length() + books[0].getTitle().length() +
                books[0].getPublishedYear().toString().length();
        for (int i = 0; i < bookcase.getBookCounter(); i++) {
            if (maxLength < books[i].getAuthor().length() + books[i].getTitle().length() +
                    books[i].getPublishedYear().toString().length()) {
                maxLength = books[i].getAuthor().length() + books[i].getTitle().length() +
                        books[i].getPublishedYear().toString().length();
            }
        }
        return maxLength;
    }
}
