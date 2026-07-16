package com.startjava.lesson_2_3_4.bookcase;

import java.util.ArrayList;
import java.util.List;

public enum Menu {
    ADD("Добавить книгу"),
    FIND("Найти и выдать книгу по названию."),
    REMOVE("Удалить книгу по названию."),
    CLEAR("Очистить шкаф."),
    CLOSE("Закрыть программу");

    private final String description;

    Menu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static List<Menu> createMenu(int bookCount, int maxCapacity) {
        List<Menu> options = new ArrayList<>();
        if (bookCount == 0) {
            options.add(ADD);
            options.add(CLOSE);
        } else if (bookCount > 0 && bookCount < maxCapacity) {
            options.add(ADD);
            options.add(FIND);
            options.add(REMOVE);
            options.add(CLEAR);
            options.add(CLOSE);
        } else {
            options.add(FIND);
            options.add(REMOVE);
            options.add(CLEAR);
            options.add(CLOSE);
        }
        return options;
    }

    public static Menu chooseOption(int inputCommand) {
        for (Menu action : values()) {
            if (action.ordinal() == (inputCommand - 1)) {
                return action;
            }
        }
        return null;
    }
}
