package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.MenuException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Menu> createMenu(int bookCount, int maxCapacity) {
        List<Menu> menuItems = new ArrayList<>();
        if (bookCount == 0) {
            menuItems.add(ADD);
            menuItems.add(CLOSE);
        } else if (bookCount > 0 && bookCount < maxCapacity) {
            menuItems.add(ADD);
            menuItems.add(FIND);
            menuItems.add(REMOVE);
            menuItems.add(CLEAR);
            menuItems.add(CLOSE);
        } else {
            menuItems.add(FIND);
            menuItems.add(REMOVE);
            menuItems.add(CLEAR);
            menuItems.add(CLOSE);
        }
        return menuItems;
    }

    public static Menu chooseOption(int inputCommand) {
        if (inputCommand >= 1 && inputCommand <= values().length) {
            for (Menu value : values()) {
                if (value.ordinal() == (inputCommand - 1)) {
                    return value;
                }
            }
        } else {
            throw new MenuException("Ошибка: Неверное значение меню (" +
                    inputCommand + ")" + " Допустимые значения " + (ADD.ordinal() + 1) +
                    " - " + (CLOSE.ordinal() + 1));
        }

        return null;
    }
}
