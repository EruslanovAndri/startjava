package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private String[] gallows = {
            "______",
            "|    |",
            "|    @",
            "|   /|\\",
            "|   / \\",
            "| GAME OVER!"
    };
    private Scanner scanner = new Scanner(System.in);
    private int currentAttempts;
    private int attemptsLeft;
    private int totalSteps;
    private String secretWord;
    private StringBuilder wrongLetters = new StringBuilder();
    private StringBuilder usedLetters = new StringBuilder();
    private StringBuilder maskOfSecretWord = new StringBuilder();

    public void start() {
        secretWord = getWordToGuess();
        maskOfSecretWord = maskWord(secretWord);
        printStartMessage(maskOfSecretWord);

        while (attemptsLeft < gallows.length) {
            char letter = inputLetter();
            currentAttempts++;
            findLetterInWord(secretWord, letter);
            replaceAsteriskToLetter(secretWord, letter, maskOfSecretWord);
            printGameInfo();
            printGallows();
            if (isWin(secretWord, maskOfSecretWord) || !hasAttempts(secretWord)) {
                break;
            }
        }
        resetCounters();
    }

    private String getWordToGuess() {
        String[] words = {"ребёнок", "шалаш", "земля", "рыба", "мир", "Хлопушка", "чайник", "хлеб"};
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index].toLowerCase();
    }

    private StringBuilder maskWord(String secretWord) {
        return new StringBuilder("*".repeat(secretWord.length()));
    }

    private void printStartMessage(StringBuilder maskOfHiddenWord) {
        System.out.println("Игра началась!" +
                "\nУгадайте слово загаданное компьютером (" + maskOfHiddenWord + ")");
    }

    private char inputLetter() {
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

    private void findLetterInWord(String secretWord, char letter) {
        if (secretWord.contains(Character.toString(letter))) {
            System.out.print("Буква (" + letter + ") есть в слове ");
            decreaseTotalSteps();
        } else {
            System.out.print("Буквы (" + letter + ") нет в слове ");
            addLetter(letter, wrongLetters);
            totalSteps++;
            attemptsLeft++;
        }
    }

    private void replaceAsteriskToLetter(String secretWord, char letter, StringBuilder maskOfHiddenWord) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                maskOfHiddenWord.setCharAt(i, Character.toUpperCase(letter));
            }
        }
    }

    private void printGallows() {
        for (int i = 0; i < totalSteps; i++) {
            System.out.println(gallows[i]);
        }
    }

    private void printGameInfo() {
        System.out.printf("""
                (%s)
                Текущее кол-во попыток - %d
                Ошибочные буквы - %s
                """, maskOfSecretWord, currentAttempts, wrongLetters);
    }

    private boolean isWin(String secretWord, StringBuilder maskOfHiddenWord) {
        if (secretWord.equals(maskOfHiddenWord.toString().toLowerCase())) {
            System.out.println("Вы угадали слово (" + secretWord.toUpperCase() +
                    ") за (" + currentAttempts + ") попыток.\n");
            return true;
        }
        return false;
    }

    private boolean hasAttempts(String secretWord) {
        if (attemptsLeft == gallows.length) {
            System.out.println("Попытки закончились! Вы не угадали слово (" +
                    secretWord.toUpperCase() + ")\n");
            return false;
        }
        return true;
    }

    private void resetCounters() {
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

    private void decreaseTotalSteps() {
        if (totalSteps != 0) totalSteps--;
    }
}
