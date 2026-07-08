package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.InvalidYearException;
import com.startjava.lesson_2_3_4.bookcase.exception.NoMoreSpaceException;
import com.startjava.lesson_2_3_4.bookcase.exception.NotFoundBookTitle;
import com.startjava.lesson_2_3_4.bookcase.exception.NotFoundMenuCommandException;
import com.startjava.lesson_2_3_4.bookcase.exception.ZeroQuantityException;
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
        MenuCommand command = MenuCommand.fromId(getUserCommand());
        switch (command) {
            case ONE -> {
                try {
                    bookcase.addBook(addDescription());
                } catch (NoMoreSpaceException | IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            case TWO -> {
                try {
                    checkFreeSpace();
                    System.out.print("Введите название искомой книги - ");
                    String title = scanner.nextLine();
                    Book[] findBook = bookcase.findBookByTitle(title);
                    showFindBook(findBook);
                } catch (ZeroQuantityException | ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
            case THREE -> {
                try {
                    checkFreeSpace();
                    System.out.print("Введите название книги для удаления - ");
                    String title = scanner.nextLine();
                    int counter = bookcase.removeBookByTitle(title);
                    System.out.println("Книга с названием " + title + " удалена");
                    System.out.println("Удалено книг: " + counter);
                } catch (ZeroQuantityException | NotFoundBookTitle e) {
                    System.out.println(e.getMessage());
                }
            }
            case FOUR -> bookcase.clearBookcase();
            case FIVE -> bookcase.close("Программа закрыта.");
            default -> scanner.nextLine();
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
        String welcomeMessage = "Программа <<Книжная полка>> приветствует вас!\n";
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
                    %d: %s
                    %d: %s 
                    """, MenuCommand.ONE.getId(), MenuCommand.ONE.getDescription(),
                    MenuCommand.TWO.getId(), MenuCommand.FIVE.getDescription());
        } else if (bookcase.getBookCounter() > 0 &&
                bookcase.getBookCounter() < bookcase.getMaxBookQuantity()) {
            System.out.printf("""
                    %d: %s
                    %d: %s 
                    %d: %s 
                    %d: %s 
                    %d: %s
                    """, MenuCommand.ONE.getId(), MenuCommand.ONE.getDescription(),
                    MenuCommand.TWO.getId(), MenuCommand.TWO.getDescription(),
                    MenuCommand.THREE.getId(), MenuCommand.THREE.getDescription(),
                    MenuCommand.FOUR.getId(), MenuCommand.FOUR.getDescription(),
                    MenuCommand.FIVE.getId(), MenuCommand.FIVE.getDescription());
        } else {
            System.out.printf("""
                    %d: %s
                    %d: %s 
                    %d: %s 
                    %d: %s 
                    """, MenuCommand.ONE.getId(), MenuCommand.TWO.getDescription(),
                    MenuCommand.TWO.getId(), MenuCommand.THREE.getDescription(),
                    MenuCommand.THREE.getId(), MenuCommand.FOUR.getDescription(),
                    MenuCommand.FOUR.getId(), MenuCommand.FIVE.getDescription());
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
            if (bookcase.getBookCounter() == bookcase.getMaxBookQuantity()) {
                command++;
            } else if (bookcase.getBookCounter() == 0 && command == 2) {
                command += 3;
            }
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

    public void showFindBook(Book[] b) {
        System.out.println("Найдено книг ");
        for (int i = 0; i < b.length; i++) {
            if (b[i] != null) {
                System.out.println(b[i].toString());
            }
        }
    }
}
