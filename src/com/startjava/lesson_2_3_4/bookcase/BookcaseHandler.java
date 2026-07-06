package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookcaseHandler {
    private static final int START_MENU_RANGE = 1;
    private static final int END_MENU_RANGE = 5;
    private static boolean begin;
    private Scanner scanner;
    private Bookcase bookcase;
    private Book book;

    public BookcaseHandler() {
        bookcase = new Bookcase();
        scanner = new Scanner(System.in);
        begin = true;
    }

    public void run() {
        if (begin) {
            typeWelcomeMessage();
            begin = false;
        }
        showMenu();
        int command = getUserCommand();
        switch (command) {
            case 1 -> {
                try {
                    bookcase.addBook(addDescription());
                } catch (Exception | StackOverflowError e) {
                    System.out.println(e.getMessage());
                }
            }
            case 2 -> {
                try {
                    checkFreeSpace();
                    System.out.print("Введите название искомой книги - ");
                    String title = scanner.nextLine();
                    book = bookcase.findBookByTitle(title);
                    System.out.println("Книга найдена " + book.toString());
                } catch (ZeroQuantityException | ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 3 -> {
                try {
                    checkFreeSpace();
                    System.out.print("Введите название книги для удаления - ");
                    String title = scanner.nextLine();
                    bookcase.removeBookByTitle(title);
                    System.out.println("Книга с названием " + title + " удалена");
                } catch (ZeroQuantityException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 4 -> bookcase.clearBookcase();
            case 5 -> bookcase.close("Программа закрыта.");
            default -> {
                return;
            }
        }
        if (pressedEnter()) {
            System.out.printf("""
                            В шкафу %d книг, свободных мест %d
                            """,
                    bookcase.getBookCounter(),
                    bookcase.getMaxBookQuantity() - bookcase.getBookCounter());
        }
        bookcase.getAllBooks();
    }

    private void typeWelcomeMessage() {
        String welcomeMessage = "Программа <<Книжная полка>> приветствует вас!";
        for (int i = 0; i < welcomeMessage.length(); i++) {
            System.out.print(welcomeMessage.charAt(i));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }

    private void showMenu() {
        if (bookcase.getBookCounter() == 0) {
            System.out.printf("""
                    \nМеню программы.
                    1. Добавить книгу.
                    2. Найти и выдать книгу по названию.
                    3. Удалить книгу по названию.
                    4. Очистить шкаф.
                    5. Закрыть программу
                    Шкаф пуст. Вы можете добавить в него первую книгу.
                    """);
        } else {
            System.out.printf("""
                    \nМеню программы.
                    1. Добавить книгу.
                    2. Найти и выдать книгу по названию.
                    3. Удалить книгу по названию.
                    4. Очистить шкаф.
                    5. Закрыть программу.
                    """);
        }
    }

    private int getUserCommand() {
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
                    throw new NotFoundMenuCommandException("Ошибка: Неверное значение меню (" +
                            command + ") " +
                            "Допустимые значения " + START_MENU_RANGE + " - " + END_MENU_RANGE);
                }
            } catch (InputMismatchException | NotFoundMenuCommandException e) {
                System.out.println(e.getMessage());
            }
            scanner.nextLine();
        }
        return command;
    }

    private Book addDescription() {
        System.out.println("Добавление новой книги");
        System.out.print("Фамилия - ");
        String author = scanner.nextLine();
        System.out.print("Название - ");
        String title = scanner.nextLine();
        Year year;
        while (true) {
            try {
                System.out.print("Год - ");
                year = Year.of(scanner.nextInt());
                scanner.nextLine();
                return new Book(author, title, year);
            } catch (InvalidYearException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkFreeSpace() {
        if (bookcase.getBookCounter() == 0) {
            throw new ZeroQuantityException("На полке нет книг");
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
}
