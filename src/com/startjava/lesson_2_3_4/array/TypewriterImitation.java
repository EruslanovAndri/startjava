package com.startjava.lesson_2_3_4.array;

public class TypewriterImitation {
    public static void main(String[] args) {
        String text = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                "- James Gosling";
        findShortestAndLongestWord(text);

        text = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                "- Robert Martin";
        findShortestAndLongestWord(text);

        text = null;
        findShortestAndLongestWord(text);

        text = "пустая строка";
        findShortestAndLongestWord(text);
    }

    private static void findShortestAndLongestWord(String text) {
        if (text == null) return;
        String cleanText = text.replaceAll("[^\\p{L}\\p{N}\\s && [^A-Z++]]", "");
        String[] splitText = cleanText.split("\\s+");
        String shortestWord = null;
        String longestWorld = null;
        for (String word : splitText) {
            word = word.trim();
            if (!word.isEmpty()) {
                if (shortestWord == null || word.length() < shortestWord.length()) {
                    shortestWord = word;
                } else if (longestWorld == null || word.length() > longestWorld.length()){
                    longestWorld = word;
                }
            }
        }
        System.out.printf("""
                Самое короткое слово в тексте - (%s)
                Самое длинное слово в тексте - (%s)
                """, shortestWord, longestWorld);
    }
}
