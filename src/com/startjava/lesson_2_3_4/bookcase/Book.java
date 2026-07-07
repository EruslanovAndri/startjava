package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;

public class Book {
    private static final int MIN_YEAR = 1800;
    private String author;
    private String title;
    private Year year;

    public Book(String author, String title, Year year) {
        this.author = validateNonNullAndBlank(author, "Фамилия автора");
        this.title = validateNonNullAndBlank(title, "Название книги");
        this.year = validateYear(year);
    }

    public String getAuthor() {
        return this.author;
    }

    public Year getYear() {
        return this.year;
    }

    public String getTitle() {
        return this.title;
    }

    private String validateNonNullAndBlank(String value, String classField) {
        if (value == null) {
            throw new NullPointerException(classField + " не может быть null! ");
        } else if (value.trim().isBlank()) {
            throw new IllegalArgumentException(classField + " не может быть пустой!");
        }
        return value;
    }

    private Year validateYear(Year year) {
        if (year.isBefore(Year.of(MIN_YEAR)) || year.isAfter(Year.now())) {
            throw new InvalidYearException("Ошибка: Год издания должен быть между " +
                    Year.of(MIN_YEAR) + " и " + Year.now());
        }
        return year;
    }

    @Override
    public String toString() {
        return String.format("| %s, %s, %s |", author, title, year);
    }
}
