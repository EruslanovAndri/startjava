package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static String[] gallows = {
            "______",
            "|    |",
            "|    @",
            "|   /|\\",
            "|   / \\",
            "| GAME OVER!"
    };
    public static Scanner scanner = new Scanner(System.in);
    public static int currentAttempts;
    public static int attemptsLeft;
    public static int totalSteps;
    public static StringBuilder wrongLetters = new StringBuilder();
    public static StringBuilder rightLetters = new StringBuilder();

    public void start() {
        String secretWord = getRandomWord();
        StringBuilder hideWord = changeLettersToAsterisk(secretWord);
        printLabel(hideWord);

        while (attemptsLeft < gallows.length) {
            char letter = inputLetter();
            if (!wrongLetters.toString().contains(Character.toString(letter)) &&
                    !rightLetters.toString().contains(Character.toString(letter))) {
                currentAttempts++;
                hasLetterInWord(secretWord, letter);
                replaceAsteriskToLetter(secretWord, letter, hideWord);
                printGallows();
                printStatus();
            } else {
                System.out.println("Повторный ввод букву (" + letter + ")\n");
            }

            if (isWin(secretWord, hideWord)) {
                break;
            } else if (isLose(secretWord)) {
                break;
            }
        }
        resetCounters();
    }

    private static void printLabel(StringBuilder hideWord) {
        System.out.println("Игра началась!\nУгадайте слово загаданное компьютером (" + hideWord + ")");
    }

    private static String getRandomWord() {
        String[] words = {"ребёнок", "шалаш", "земля", "рыба", "мир"};
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index].toLowerCase();
    }

    private static StringBuilder changeLettersToAsterisk(String word) {
        StringBuilder hideWord = new StringBuilder(word.replaceAll("[а-я-ё]", "*"));
        return hideWord;
    }

    private static char inputLetter() {
        boolean isCyrillic = true;
        while (isCyrillic) {
            System.out.print("Введите букву от а-я: ");
            char letter = scanner.next().toLowerCase().charAt(0);
            if (letter >= 'а' && letter <= 'я' || letter == 'ё') {
                return letter;
            } else {
                System.out.println("\nНекорректный ввод! \nВведенная буква не входит в Кириллицу.\n");
            }
        }
        return ' ';
    }

    private static void hasLetterInWord(String word, char letter) {
        if (word.contains(Character.toString(letter))) {
            System.out.print("Буква (" + letter + ") есть в слове ");
            addLetter(letter, rightLetters);
            decrease();
        } else {
            System.out.print("Буквы (" + letter + ") нет в слове ");
            addLetter(letter, wrongLetters);
            increase();
            attemptsLeft++;
        }
    }

    private static void replaceAsteriskToLetter(String originWord, char letter, StringBuilder targetWord) {
        for (int i = 0; i < originWord.length(); i++) {
            if (originWord.charAt(i) == letter) {
                targetWord.replace(i, i + 1, Character.toString(letter).toUpperCase());
            }
        }
        System.out.println("(" + targetWord + ")");
    }

    private static void printStatus() {
        System.out.printf("""
                    Текущее кол-во попыток - %d
                    Ошибочные буквы - %s%n
                    """, currentAttempts, wrongLetters);
    }

    private static void printGallows() {
        for (int i = 0; i < totalSteps; i++) {
            System.out.println(gallows[i]);
        }
    }

    private static boolean isWin(String word, StringBuilder hideWord) {
        if (word.equals(hideWord.toString().toLowerCase())) {
            System.out.println("Вы угадали слово (" + word.toUpperCase() +
                    ") за (" + currentAttempts + ") попыток.\n");
            return true;
        }
        return false;
    }

    private static boolean isLose(String word) {
        if (attemptsLeft == gallows.length) {
            System.out.println("Вы не угадали слово (" + word.toUpperCase() + ")\n");
            return true;
        }
        return false;
    }

    private static void addLetter(char letter, StringBuilder letters) {
        if (!letters.toString().contains(Character.toString(letter))) {
            letters.append(letter).append(" ");
        }
    }

    private static void increase() {
        totalSteps++;
    }

    private static void decrease() {
        if (totalSteps != 0) totalSteps--;
    }

    private static void resetCounters() {
        currentAttempts = 0;
        totalSteps = 0;
        attemptsLeft = 0;
        wrongLetters.setLength(0);
        rightLetters.setLength(0);
    }
}
