package com.startjava.lesson_2_3_4.array;

public class TypewriterImitation {
    public static void main(String[] args) {
        String[] texts = {
                "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                        "- James Gosling",
                "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                        "- Robert Martin",
                null, ""};
        for (String text : texts) {
            int[] shortAndLongWord = findShortestLongestWordIndex(text);
            StringBuilder convertToUpperCase = convertToUpperCase(shortAndLongWord, text);
            imitateTypewriter(convertToUpperCase);
        }
    }

    private static int[] findShortestLongestWordIndex(String text) {
        if (text == null) return null;
        String[] cleanText = text.split(" ");
        int index = 0;
        String shortestWord = null;
        int shortWordIndex = 0;
        String longestWord = null;
        int longWordIndex = 0;
        for (String word : cleanText) {
            word = word.trim();
            if (!word.isEmpty() && !word.matches("\\p{Punct}")) {
                if (shortestWord == null || word.length() < shortestWord.length()) {
                    shortestWord = word;
                    shortWordIndex = index;
                } else if (longestWord == null || word.length() > longestWord.length()) {
                    longestWord = word;
                    longWordIndex = index;
                }
            }
            index++;
        }
        int[] shortAndLongWordIndex = (shortWordIndex > longWordIndex) ?
                new int[]{longWordIndex, shortWordIndex} :
                new int[]{shortWordIndex, longWordIndex};
        return shortAndLongWordIndex;
    }

    private static StringBuilder convertToUpperCase(int[] shortAndLongWordIndex, String text) {
        StringBuilder toUpperCase = new StringBuilder();
        if (text == null) {
            System.out.println(toUpperCase.append("null"));
            return null;
        }
        if (text.equals("")) toUpperCase.append("Пустой текст.");
        String[] cleanText = text.split(" ");
        for (int i = 0; i < cleanText.length; i++) {
            if (i >= shortAndLongWordIndex[0] && i <= shortAndLongWordIndex[1]) {
                toUpperCase.append(cleanText[i].toUpperCase()).append(" ");
            } else {
                toUpperCase.append(cleanText[i]).append(" ");
            }
        }
        return toUpperCase;
    }

    private static void imitateTypewriter(StringBuilder text) {
        if (text == null) {
            return;
        }
        if (text.equals("")) System.out.println("Ошибка - пустой текст.");

        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }
}
