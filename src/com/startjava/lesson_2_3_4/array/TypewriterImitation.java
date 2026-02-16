package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TypewriterImitation {
    public static void main(String[] args) {
        String[] texts = {
                "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                        "- James Gosling",
                "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                        "- Robert Martin",
                null, ""};
        for (String text : texts) {
            String[] shortAndLongWord = findShortestLongestWord(text);
            typeText(text, shortAndLongWord);
        }
    }

    private static String[] findShortestLongestWord(String text) {
        if (text == null) return null;
        String[] cleanText = text.replaceAll("[^a-zA-z0-9а-яА-я[++]]", " ").split("\\s++");
        String shortestWord = null;
        String longestWord = null;
        for (String word : cleanText) {
            word = word.trim();
            if (!word.isEmpty()) {
                if (shortestWord == null || word.length() < shortestWord.length()) {
                    shortestWord = word;
                } else {
                    if (longestWord == null || word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }
        }
        String[] shortAndLongWord = {shortestWord, longestWord};
        return shortAndLongWord;
    }

    private static void typeText(String text, String[] shortAndLongWord) {
        if (text == null) {
            System.out.println("null");
            return;
        }
        if (text.equals("")) System.out.println("Ошибка - пустой текст.");
        int shortestWordIndex = 0;
        int longestWordIndex = 0;

        String[] cleanText = text.replaceAll("[^a-zA-Z0-9а-яА-Я.[++-]\\s]", "").split(" ");
        for (int i = 0; i < cleanText.length; i++) {
            if (cleanText[i].equals(shortAndLongWord[0])) {
                shortestWordIndex = i;
            } else if (cleanText[i].equals(shortAndLongWord[1])) {
                longestWordIndex = i;
            }
        }

        for (int i = 0; i < cleanText.length; i++) {
            if (shortestWordIndex > longestWordIndex) {
                if (i > longestWordIndex - 1 && i <= shortestWordIndex) {
                    System.out.print(cleanText[i].toUpperCase() + " ");
                } else {
                    System.out.print(cleanText[i] + " ");
                }
            } else {
                if (i > shortestWordIndex - 1 && i <= longestWordIndex) {
                    System.out.print(cleanText[i].toUpperCase() + " ");
                } else {
                    System.out.print(cleanText[i] + " ");
                }
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }
}
