package com.startjava.lesson_2_3_4.array;

public class TypewriterImitation {
    public static void main(String[] args) {
        String text = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        String shortestWord = findShortestWord(text);
        String longestWord = findLongestWord(text);
        typeText(text, shortestWord, longestWord);

        text = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        shortestWord = findShortestWord(text);
        longestWord = findLongestWord(text);
        typeText(text, shortestWord, longestWord);

        text = null;
        shortestWord = findShortestWord(text);
        longestWord = findLongestWord(text);
        typeText(text, shortestWord, longestWord);

        text = "пустая строка";
        shortestWord = findShortestWord(text);
        longestWord = findLongestWord(text);
        typeText(text, shortestWord, longestWord);
    }

    private static String findShortestWord(String text) {
        if (text == null) return null;
        String[] cleanText = text.replaceAll("[^a-zA-z0-9а-яА-я[++]]", " ").split("\\s++");
        String shortestWord = null;
        for (String word : cleanText) {
            word = word.trim();
            if (!word.isEmpty()) {
                if (shortestWord == null || word.length() < shortestWord.length()) {
                    shortestWord = word;
                }
            }
        }
        return shortestWord;
    }

    private static String findLongestWord(String text) {
        if (text == null) return null;
        String[] cleanText = text.replaceAll("[^a-zA-Z0-9а-яА-Я[++]]", " ").split("\\s++");
        String longestWord = null;
        for (String word : cleanText) {
            word = word.trim();
            if (!word.isEmpty()) {
                if (longestWord == null || word.length() >= longestWord.length()) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }

    private static void typeText(String text, String shortestWord, String longestWord) {
        if (text == null) return;
        int shortestWordIndex = 0;
        int longestWordIndex = 0;
        String[] cleanText = text.replaceAll("[^a-zA-Z0-9а-яА-Я[++-]]", " ").split("\\s++");
        for (int i = 0; i < cleanText.length; i++) {
            if (cleanText[i].equals(shortestWord)) {
                shortestWordIndex = i;
            }
        }
        for (int i = 0; i < cleanText.length; i++) {
            if (cleanText[i].equals(longestWord)) {
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
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                if (i > shortestWordIndex - 1 && i <= longestWordIndex) {
                    System.out.print(cleanText[i].toUpperCase() + " ");
                } else {
                    System.out.print(cleanText[i] + " ");
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println();
    }
}
