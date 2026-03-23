package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static String[] gallows = {
            "______",
            "|    |",
            "|    @",
            "|   /|\\",
            "|   / \\",
            "| GAME OVER!"
    };
    private static Scanner scanner = new Scanner(System.in);
    private static int currentAttempts;
    private static int attemptsLeft;
    private static int totalSteps;
    private static StringBuilder wrongLetters = new StringBuilder();
    private static StringBuilder usedLetters = new StringBuilder();

    public void start() {
        String secretWord = getWordToGuess();
        StringBuilder hiddenWord = maskWord(secretWord);
        printStartMessage(hiddenWord);

        while (attemptsLeft < gallows.length) {
            char letter = inputLetter();
            currentAttempts++;
            findLetterInWord(secretWord, letter);
            replaceAsteriskToLetter(secretWord, letter, hiddenWord);
            printGallows();
            printGameInfo();
            if (isWin(secretWord, hiddenWord)) {
                break;
            } else if (hasAttempts(secretWord)) {
                break;
            }
        }
        resetCounters();
    }

    private static String getWordToGuess() {
        String[] words = {"ребёнок", "шалаш", "земля", "рыба", "мир", "Хлопушка"};
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index].toLowerCase();
    }

    private static StringBuilder maskWord(String word) {
        return new StringBuilder("*".repeat(word.length()));
    }

    private static void printStartMessage(StringBuilder hiddenWord) {
        System.out.println("Игра началась!\nУгадайте слово загаданное компьютером (" + hiddenWord + ")");
    }

    private static char inputLetter() {
        while (true) {
            System.out.print("Введите букву от а-я: ");
            char letter = scanner.next().toLowerCase().charAt(0);
            if (!(letter >= 'а' && letter <= 'я' || letter == 'ё')) {
                System.out.println("\nНекорректный ввод! \nВведенная буква не входит в Кириллицу.\n");
            } else if (!addLetter(letter, usedLetters)) {
                System.out.println("Повторный ввод букву (" + letter + ")\n");
            } else {
                return letter;
            }
        }
    }

    private static void findLetterInWord(String word, char letter) {
        if (word.contains(Character.toString(letter))) {
            System.out.print("Буква (" + letter + ") есть в слове ");
            decreaseTotalSteps();
        } else {
            System.out.print("Буквы (" + letter + ") нет в слове ");
            addLetter(letter, wrongLetters);
            totalSteps++;
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

    private static void printGallows() {
        for (int i = 0; i < totalSteps; i++) {
            System.out.println(gallows[i]);
        }
    }

    private static void printGameInfo() {
        System.out.printf("""
                    Текущее кол-во попыток - %d
                    Ошибочные буквы - %s%n
                    """, currentAttempts, wrongLetters);
    }

    private static boolean isWin(String word, StringBuilder hideWord) {
        if (word.equals(hideWord.toString().toLowerCase())) {
            System.out.println("Вы угадали слово (" + word.toUpperCase() +
                    ") за (" + currentAttempts + ") попыток.\n");
            return true;
        }
        return false;
    }

    private static boolean hasAttempts(String word) {
        if (attemptsLeft == gallows.length) {
            System.out.println("Вы не угадали слово (" + word.toUpperCase() + ")\n");
            return true;
        }
        return false;
    }

    private static void resetCounters() {
        currentAttempts = 0;
        totalSteps = 0;
        attemptsLeft = 0;
        wrongLetters.setLength(0);
        usedLetters.setLength(0);
    }

    private static boolean addLetter(char letter, StringBuilder letters) {
        if (letters.indexOf(Character.toString(letter)) == -1) {
            letters.append(letter).append(" ");
            return true;
        }
        return false;
    }

    private static void decreaseTotalSteps() {
        if (totalSteps != 0) totalSteps--;
    }
}
