package com.startjava.lesson_2_3_4.bookcase;

public enum MenuCommand {
    ONE(1,"Добавить книгу"),
    TWO(2,"Найти и выдать книгу по названию."),
    THREE(3,"Удалить книгу по названию."),
    FOUR(4,"Очистить шкаф."),
    FIVE(5,"Закрыть программу");


    private final int id;
    private final String description;

    MenuCommand(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static MenuCommand fromId(int id) {
        for (MenuCommand input : values()) {
            if (input.id == id) {
                return input;
            }
        }
        return null;
    }
}
