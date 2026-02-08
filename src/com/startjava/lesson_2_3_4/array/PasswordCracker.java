package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class PasswordCracker {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String RESET = "\033[0m";
    private static final int MIN_LENGTH = 8;
    private static char[][] passwordBlackList = {
            {'a', 'd', 'm', 'i', 'n'},
            {'q', 'w', 'e', 'r', 't', 'y'},
            {'1', '2', '3', '4', '5', '6'}};

    public static void main(String[] args) {
        char[] password = {'1', '2', '3', '4', '5', '6'};
        checkPassword(password);

        password = generatePassword();
        checkPassword(password);

        password = generatePassword();
        checkPassword(password);

        password = generatePassword();
        checkPassword(password);
    }

    public char[][] getPasswordBlackList() {
        return this.passwordBlackList;
    }

    private static char[] generatePassword() {
        Random random = new Random();
        int length = random.nextInt(6, 13);
        char[] password = new char[length];
        for (int i = 0; i < password.length; i++) {
            password[i] = (char) random.nextInt(33, 123);
        }
        return password;
    }

    private static void runSpinner() {
        char[] spinner = {'-', '\\', '|', '/'};
        int counter = 0;
        StringBuilder spinnerSb = new StringBuilder();
        for (int i = 0; i < 36; i++) {
            spinnerSb.append("\b" + spinner[counter % spinner.length]);
            System.out.print(spinnerSb.append("\r"));
            counter++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void checkPassword(char[] password) {
        runSpinner();
        PasswordCracker passwordCracker = new PasswordCracker();
        for (char[] element : passwordCracker.getPasswordBlackList()) {
            if (Arrays.equals(element, password)) {
                System.out.println("Не используйте пароли из списка популярных. - " +
                        Arrays.toString(password));
                System.out.println(passwordCracker.getClass().getName());
                return;
            }
        }

        if (password.length == 0) {
            System.out.println("Пароль не может быть пустым - " + Arrays.toString(password));
            return;
        }
        if (password.length < MIN_LENGTH) {
            System.out.println("Пароль должен быть не менее 8 символов. - " + Arrays.toString(password));
            return;
        }

        boolean hasDigits = false;
        boolean hasLowerCaseLetters = false;
        boolean hasUpperCaseLetters = false;
        boolean hasSpecialSymbols = false;

        for (char ch : password) {
            if (Character.isDigit(ch)) {
                hasDigits = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCaseLetters = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpperCaseLetters = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialSymbols = true;
            }
        }

        if (password != null && password.length > MIN_LENGTH && hasDigits &&
                !hasSpecialSymbols && !hasUpperCaseLetters && !hasLowerCaseLetters) {
            System.out.println("Пароль содержит только цифры - " + Arrays.toString(password));
        } else if (!hasDigits && !hasSpecialSymbols && hasUpperCaseLetters && hasLowerCaseLetters) {
            System.out.println("Пароль содержит только буквы - " + Arrays.toString(password));
        } else if (hasSpecialSymbols && !hasDigits && !hasUpperCaseLetters && !hasLowerCaseLetters) {
            System.out.println("Пароль содердит только спец. символы - " + Arrays.toString(password));
        } else if (hasDigits && hasUpperCaseLetters && hasLowerCaseLetters && !hasSpecialSymbols) {
            System.out.println("Пароль не содержит спец. символы - " + Arrays.toString(password));
        } else if (hasDigits && hasSpecialSymbols && !hasUpperCaseLetters && !hasLowerCaseLetters) {
            System.out.println("Пароль не содержит буквы нижнего и верхнего регистров - " +
                    Arrays.toString(password));
        } else if (hasDigits && hasSpecialSymbols && hasUpperCaseLetters && hasLowerCaseLetters) {
            System.out.println(ANSI_GREEN + "✓ Password cracked: - " + Arrays.toString(password) +
                    RESET);
        } else {
            System.out.println(ANSI_RED + "✗ Strong password: - " + Arrays.toString(password) +
                    RESET);
        }
    }
}
