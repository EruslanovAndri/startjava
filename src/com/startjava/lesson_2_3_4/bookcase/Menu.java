package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.MenuIndexOutOfBoundsException;

public enum Menu {
    ADD("Добавить книгу."),
    FIND("Найти и выдать книгу по названию."),
    REMOVE("Удалить книгу по названию."),
    CLEAR("Очистить шкаф."),
    CLOSE("Закрыть программу.");

    private final String description;

    Menu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Menu[] createMenu(int bookCount, int maxCapacity) {
        if (bookCount == 0) {
            return new Menu[]{ADD, CLOSE};
        } else if (bookCount > 0 && bookCount < maxCapacity) {
            return new Menu[]{ADD, FIND, REMOVE, CLEAR, CLOSE};
        } else {
            return new Menu[]{ FIND, REMOVE, CLEAR, CLOSE};
        }
    }

    public static Menu chooseOption(int inputCommand, int bookCount, int maxCapacity) {
        Menu[] menu = createMenu(bookCount, maxCapacity);
        if (inputCommand < 1 || inputCommand > menu.length) {
            throw new MenuIndexOutOfBoundsException("Ошибка: Неверное значение меню (" +
                    inputCommand + ")" + " Допустимые значения " + (1) +
                    " - " + (menu.length));
        }
        return menu[inputCommand - 1];
    }
}
