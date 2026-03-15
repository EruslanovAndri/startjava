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

    public void startGame() {
        String randomWord = getRandomWord();
        StringBuilder hideWord = new StringBuilder(randomWord.replaceAll("[а-я-ё]", "*"));
        printMessage("Игра началась!\nУгадайте слово загаданное компьютером (" + hideWord + ")");

        while (guessedLettersCounter != randomWord.length()) {
            char letter = inputLetter();
            if (!randomWord.contains(Character.toString(letter))) {
                printMessage("Буквы (" + letter + ") нет в слове (" + hideWord + ")");
                if (addLetter(letter, wrongLetters)) {
                    addTotalStep();
                }
            } else if (randomWord.contains(Character.toString(letter))) {
                printMessage("Буква (" + letter + ") есть в слове (" + hideWord + ")");
                replaceAsterisk(randomWord, letter, hideWord);
                if (addLetter(letter, rightLetters)) {
                    guessedLettersCounter++;
                    subtractTotalStep();
                }
            }
            attempts++;
            drawGallows();
            printMessage("Ошибочные буквы - " + wrongLetters);
            printMessage("Количество правильных букв - " + guessedLettersCounter);
            printMessage("Правильные буквы - " + rightLetters);

            if (randomWord.equals(hideWord.toString().toLowerCase())) {
                printMessage("Вы угадали слово (" + randomWord.toUpperCase() +
                        ") за (" + attempts + ") попыток.");
                resetCounters();
                break;
            } else if (totalSteps == gallows.length) {
                printMessage("Вы не угадали слово (" + randomWord.toUpperCase() + ")");
                resetCounters();
                break;
            }
        }
    }

    private static void drawGallows() {
        for (int i = 0; i < totalSteps; i++) {
            System.out.println(gallows[i]);
        }
    }

    private static char inputLetter() {
        boolean isCyrillic = true;
        while (isCyrillic) {
            System.out.print("Введите букву от а-я: ");
            char letter = scanner.next().toLowerCase().charAt(0);
            if (letter >= 'а' && letter <= 'я' || letter == 'ё') {
                return letter;
            } else {
                printMessage("Некорректный ввод!");
            }
        }
        return ' ';
    }

    private static String getRandomWord() {
        String[] words = {"ребёнок", "шалаш", "земля", "рыба", "мир"};
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index].toLowerCase();
    }

    private static void printMessage(String message) {
        System.out.println(message);
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

    private static void replaceAsterisk(String originWord, char letter, StringBuilder targetWord) {
        for (int i = 0; i < originWord.length(); i++) {
            if (originWord.charAt(i) == letter) {
                targetWord.replace(i, i + 1, Character.toString(letter).toUpperCase());
            }
        }
    }
}
