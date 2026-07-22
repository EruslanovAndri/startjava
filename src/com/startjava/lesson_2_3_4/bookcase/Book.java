package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;
import java.util.Objects;

public class Book {
    private static final int MIN_YEAR = 1800;
    private String author;
    private String title;
    private Year publishedYear;

    public Book(String author, String title, Year publishedYear) {
        this.author = validateNonNullAndBlank(author, "Фамилия автора");
        this.title = validateNonNullAndBlank(title, "Название книги");
        this.publishedYear = validateYear(publishedYear);
    }

    private String validateNonNullAndBlank(String value, String inputString) {
        Objects.requireNonNull(value, inputString + " не может быть null! ");
        if (value.trim().isBlank()) {
            throw new IllegalArgumentException(inputString + " не может быть пустой!");
        }
        return value;
    }

    private Year validateYear(Year publishedYear) {
        if (publishedYear.isBefore(Year.of(MIN_YEAR)) || publishedYear.isAfter(Year.now())) {
            throw new IllegalArgumentException("Ошибка: Год издания должен быть между " +
                    Year.of(MIN_YEAR) + " и " + Year.now());
        }
        return publishedYear;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", author, title, publishedYear);
    }
}
