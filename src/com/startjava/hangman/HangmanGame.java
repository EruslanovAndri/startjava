package com.startjava.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static int counter;
    public static int attempts;
    public static int guessedLetters;
    public static Scanner scanner = new Scanner(System.in);
    public static String[] hangman = {
            "______",
            "|    |",
            "|    @",
            "|   /|\\",
            "|   / \\",
            "| GAME OVER!"
    };

    public static void startGame() {
        String randomWord = getRandomWord();
        StringBuilder mistakes = new StringBuilder();
        StringBuilder usedLetters = new StringBuilder();
        StringBuilder hideWord = new StringBuilder(randomWord.replaceAll("[а-я-ё]", "*"));

        printMessage("Игра началась!\nУгадайте слово загаданное компьютером (" + hideWord + ")");

        while (guessedLetters != randomWord.length()) {
            char inputChar = getChar();
            attempts++;

            if (!randomWord.contains(Character.toString(inputChar))) {
                printMessage("Буквы (" + inputChar + ") нет в слове (" + hideWord + ")");
                if (!mistakes.toString().contains(Character.toString(inputChar))) {
                    mistakes.append(inputChar).append(" ");
                    counter++;
                }
                drawHangman();
            } else if (randomWord.contains(Character.toString(inputChar))) {
                for (int i = 0; i < randomWord.length(); i++) {
                    if (randomWord.charAt(i) == inputChar) {
                        hideWord.replace(i, i + 1, Character.toString(inputChar).toUpperCase());
                    }
                }
                if (!usedLetters.toString().contains(Character.toString(inputChar))) {
                    usedLetters.append(inputChar);
                    guessedLetters++;
                    if (counter != 0) {
                        counter--;
                        drawHangman();
                    }
                }
                printMessage("Буква (" + inputChar + ") есть в слове (" + hideWord + ")");
            }
            printMessage("Ошибочные буквы - " + mistakes);
            printMessage("Правильные буквы - " + guessedLetters);

            if (randomWord.equals(hideWord.toString().toLowerCase())) {
                printMessage("Вы угадали слово (" + randomWord.toUpperCase() +
                        ") за (" + attempts + ") попыток.");
                counter = 0;
                usedLetters.setLength(0);
                attempts = 0;
                guessedLetters = 0;
                break;
            } else if (counter == hangman.length) {
                printMessage("Вы не угадали слово (" + randomWord.toUpperCase() + ")");
                counter = 0;
                usedLetters.setLength(0);
                attempts = 0;
                guessedLetters = 0;
                break;
            }
        }
    }

    private static void drawHangman() {
        for (int i = 0; i < counter; i++) {
            System.out.println(hangman[i]);
        }
    }

    private static char getChar() {
        char inputChar = '-';
        boolean isCyrillic = true;
        while (isCyrillic) {
            System.out.print("Введите букву от а-я: ");
            char temp = scanner.next().toLowerCase().charAt(0);
            if (temp >= 'а' && temp <= 'я' || temp == 'ё') {
                inputChar = temp;
                isCyrillic = false;
            } else {
                printMessage("Некорректный ввод!");
            }
        }
        return inputChar;
    }

    private static String getRandomWord() {
        String[] words = {"ребёнок", "шалаш", "земля", "рыба", "мир"};
        Random random = new Random();
        int index = random.nextInt(words.length);
        String secretWord = words[index].toLowerCase();
        return secretWord;
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
