package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.MenuException;

public enum MenuItem {
    ADD("Добавить книгу."),
    FIND("Найти и выдать книгу по названию."),
    REMOVE("Удалить книгу по названию."),
    CLEAR("Очистить шкаф."),
    CLOSE("Закрыть программу.");

    private final String description;

    MenuItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static MenuItem[] createMenu(int bookCount, int maxCapacity) {
        if (bookCount == 0) {
            return new MenuItem[]{ADD, CLOSE};
        } else if (bookCount > 0 && bookCount < maxCapacity) {
            return new MenuItem[]{ADD, FIND, REMOVE, CLEAR, CLOSE};
        } else {
            return new MenuItem[]{ FIND, REMOVE, CLEAR, CLOSE};
        }
    }

    public static MenuItem chooseOption(int inputCommand) {
        if (inputCommand >= 1 && inputCommand <= values().length) {
            for (MenuItem value : values()) {
                if (value.ordinal() == (inputCommand - 1)) {
                    return value;
                }
            }
        } else {
            throw new MenuException("Ошибка: Неверное значение меню (" +
                    inputCommand + ")" + " Допустимые значения " + (1) +
                    " - " + (inputCommand));
        }

        return null;
    }
}
