package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;
import java.util.Objects;

public class Book {
    private static final int MIN_YEAR = 1800;
    private String author;
    private String title;
    private Year releaseYear;

    public Book(String author, String title, Year releaseYear) {
        this.author = validateNonNullAndBlank(author, "Фамилия автора");
        this.title = validateNonNullAndBlank(title, "Название книги");
        this.releaseYear = validateYear(releaseYear);
    }

    private String validateNonNullAndBlank(String value, String classField) {
        Objects.requireNonNull(value, classField + " не может быть null! ");
        if (value.trim().isBlank()) {
            throw new IllegalArgumentException(classField + " не может быть пустой!");
        }
        return value;
    }

    private Year validateYear(Year year) {
        if (year.isBefore(Year.of(MIN_YEAR)) || year.isAfter(Year.now())) {
            throw new IllegalArgumentException("Ошибка: Год издания должен быть между " +
                    Year.of(MIN_YEAR) + " и " + Year.now());
        }
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return String.format("| %s, %s, %s |", author, title, releaseYear);
    }
}
