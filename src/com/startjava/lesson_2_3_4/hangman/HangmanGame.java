package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static int totalSteps;
    public static int attempts;
    public static int guessedLettersCounter;
    public static StringBuilder wrongLetters = new StringBuilder();
    public static StringBuilder rightLetters = new StringBuilder();
    public static Scanner scanner = new Scanner(System.in);
    public static String[] gallows = {
            "______",
            "|    |",
            "|    @",
            "|   /|\\",
            "|   / \\",
            "| GAME OVER!"
    };

    public void start() {
        String secretWord = getRandomWord();
        int length = secretWord.length();
        StringBuilder hideWord = changeLettersToAsterisk(secretWord);
        printLabel(hideWord);

        while (guessedLettersCounter != length) {
            char letter = inputLetter();
            attempts++;
            hasLetterInWord(secretWord, letter);
            replaceAsteriskToLetter(secretWord, letter, hideWord);
            printStatus();
            drawGallows();
            if (isWin(secretWord, hideWord)) {
                break;
            } else if (isLose(totalSteps, gallows.length, secretWord)) {
                break;
            }
        }
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
                System.out.println("Некорректный ввод!");
            }
        }
        return ' ';
    }

    private static void hasLetterInWord(String word, char letter) {
        if (word.contains(Character.toString(letter))) {
            System.out.print("Буква (" + letter + ") есть в слове ");
            addLetter(letter, rightLetters);
            subtractTotalStep();
        } else {
            System.out.print("Буквы (" + letter + ") нет в слове ");
            addLetter(letter, wrongLetters);
            addTotalStep();
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
                    Ошибочные буквы - %s
                    Количество правильных букв - %d
                    Правильные буквы - %s
                    """, wrongLetters, guessedLettersCounter, rightLetters);
    }

    private static void drawGallows() {
        for (int i = 0; i < totalSteps; i++) {
            System.out.println(gallows[i]);
        }
    }

    private static boolean isWin(String word, StringBuilder hideWord) {
        if (word.equals(hideWord.toString().toLowerCase())) {
            System.out.println("Вы угадали слово (" + word.toUpperCase() +
                    ") за (" + attempts + ") попыток.");
            resetCounters();
            return true;
        }
        return false;
    }

    private static boolean isLose(int steps, int length, String word) {
        if (steps == length) {
            System.out.println("Вы не угадали слово (" + word.toUpperCase() + ")");
            resetCounters();
            return true;
        }
        return false;
    }

    private static boolean addLetter(char letter, StringBuilder letters) {
        if (!letters.toString().contains(Character.toString(letter))) {
            letters.append(letter).append(" ");
            return true;
        }
        return false;
    }

    private static void addTotalStep() {
        totalSteps++;
    }

    private static void subtractTotalStep() {
        if (totalSteps != 0) totalSteps--;
    }

    private static void resetCounters() {
        totalSteps = 0;
        attempts = 0;
        guessedLettersCounter = 0;
        wrongLetters.setLength(0);
        rightLetters.setLength(0);
    }
}
