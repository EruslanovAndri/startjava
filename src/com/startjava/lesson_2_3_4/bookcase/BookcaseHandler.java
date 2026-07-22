package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.BookNotExistException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookcaseOverflowException;
import com.startjava.lesson_2_3_4.bookcase.exception.ExitException;
import com.startjava.lesson_2_3_4.bookcase.exception.MenuIndexOutOfBoundsException;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookcaseHandler {
    private static final int SPEED = 50;
    private static final int MAX_INDENT = 2;
    private Scanner scanner;
    private Bookcase bookcase;

    public BookcaseHandler() {
        bookcase = new Bookcase();
        scanner = new Scanner(System.in);
        typeWelcomeMessage();
    }

    public void run() {
        Menu[] menu = Menu.createMenu(bookcase.getBookCounter(), bookcase.CAPACITY);
        printMenu(menu);
        Menu menuItem = inputCommand();
        try {
            scanner.nextLine();
            performSwitchCaseOperation(menuItem);
            pressedEnter();
            updateBookcaseInformation();
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

    private void printMenu(Menu[] menuItems) {
        for (int i = 1; i <= menuItems.length; i++) {
            System.out.println(i + "." + menuItems[i - 1].getDescription());
        }
    }

    private Menu inputCommand() {
        while (true) {
            try {
                System.out.print("Введите команду - ");
                if (!scanner.hasNextInt()) {
                    throw new InputMismatchException("Ошибка: Необходимо ввести целое число.");
                }
                Menu menuItem = Menu.chooseOption(scanner.nextInt(), bookcase.getBookCounter(),
                        bookcase.CAPACITY);
                return menuItem;
            } catch (InputMismatchException | MenuIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            scanner.nextLine();
        }
    }

    private void performSwitchCaseOperation(Menu menuItem) {
        switch (menuItem) {
            case ADD -> bookcase.addBook(addDescription());
            case FIND -> findBook();
            case REMOVE -> removeBook();
            case CLEAR -> bookcase.clearBookcase();
            case CLOSE -> throw new ExitException("Программа закрыта.");
            default -> System.out.println("Default");
        }
    }

    private void pressedEnter() {
        System.out.print("Для продолжения работы нажмите <Enter> ");
        String enter = scanner.nextLine();
        if (!enter.isEmpty()) {
            pressedEnter();
        }
    }

    private void updateBookcaseInformation() {
        System.out.printf("""
                          В шкафу %d книг, свободных мест %d
                          """, bookcase.getBookCounter(), bookcase.CAPACITY - bookcase.getBookCounter());
    }

    private void printBookcase() {
        Book[] books = bookcase.getAllBooks();
        for (Book book : books) {
            System.out.println("| " + book + " |");
            System.out.println("|" + "-".repeat(bookcase.bookcaseLength + MAX_INDENT) + "|");
        }
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

    private void findBook() {
        System.out.print("Введите название искомой книги - ");
        String title = scanner.nextLine();
        Book[] foundBook = bookcase.findBooks(title);
        System.out.println("Найдено книг " + bookcase.getCounter());
        showFoundBook(foundBook);
    }

    private void showFoundBook(Book[] books) {
        for (Book book : books) {
            if (book != null) {
                System.out.println("| " + book + " |");
            }
        }
    }

    private void removeBook() {
        System.out.print("Введите название книги для удаления - ");
        String title = scanner.nextLine();
        bookcase.removeBooks(title);
        System.out.println("Удалено книг: " + bookcase.getCounter());
    }
}
