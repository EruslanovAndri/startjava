package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class PasswordCracker {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String RESET = "\033[0m";

    public static void main(String[] args) {
        String[][] passwordBlackList = {{"admin"}, {"qwerty"}, {"123456"}};
        char[] password = {'1', '2', '3', '4', '5', '6'};
        checkPassword(password, passwordBlackList);

        password = passwordGenerator();
        checkPassword(password, passwordBlackList);

        password = passwordGenerator();
        checkPassword(password, passwordBlackList);

        password = passwordGenerator();
        checkPassword(password, passwordBlackList);
    }

    private static char[] passwordGenerator() {
        Random random = new Random();
        int length = random.nextInt(6, 13);
        char[] password = new char[length];
        runSpinner();
        for (int i = 0; i < password.length; i++) {
            password[i] = (char) random.nextInt(33, 122);
        }
        return password;
    }

    private static void runSpinner() {
        char[] spinner = {'-', '\\', '|', '/'};
        int counter = 0;
        StringBuilder spinnerSb = new StringBuilder();
        for (int i = 0; i < 36; i++) {
            spinnerSb.append("\b" + spinner[counter % spinner.length]);
            System.out.print(spinnerSb);
            counter++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void checkPassword(char[] password, String[][] passwordBlackList) {
        for (int i = 0; i < passwordBlackList.length; i++) {
            char[] blackListPassword = passwordBlackList[i][0].toCharArray();
            if (Arrays.equals(password, blackListPassword)) {
                System.out.println("Не используйте пароли из списка популярных:");
                return;
            }
        }

        boolean hasDigits = false;
        boolean hasLetters = false;
        boolean hasSpecialSymbols = false;
        boolean hasUpperCaseLetters = false;
        boolean hasLowerCaseLetters = false;

        if (password.length == 0) {
            System.out.println("Пароль не может быть пустым");
            return;
        }
        if (password.length > 8 && password.length <= 12) {
            System.out.println("\nПароль должен быть не менее 8 символов.");
            return;
        }
        for (int i = 0; i < password.length; i++) {
            if (Character.isDigit(password[i])) {
                hasDigits = true;
            } else if (Character.isLetter(password[i])) {
                hasLetters = true;
            } else if (!Character.isLetterOrDigit(password[i])) {
                hasSpecialSymbols = true;
            }
            if (Character.isUpperCase(password[i])) {
                hasUpperCaseLetters = true;
            }
            if (Character.isLowerCase(password[i])) {
                hasLowerCaseLetters = true;
            }
        }
        if (password != null && password.length > 8 && password.length <= 12 &&
                hasDigits && hasLetters && hasSpecialSymbols && hasUpperCaseLetters &&
                hasLowerCaseLetters) {
            System.out.println("\n" + ANSI_GREEN + "✓ Password cracked: " + Arrays.toString(password) +
                    RESET);
        } else {
            System.out.println("\n" + ANSI_RED + "✗ Strong password: " + Arrays.toString(password) +
                    RESET);
        }
    }
}
