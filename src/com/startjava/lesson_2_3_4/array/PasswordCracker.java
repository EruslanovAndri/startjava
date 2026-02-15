package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class PasswordCracker {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String RESET = "\033[0m";
    private static final int MIN_LENGTH = 8;
    private static final int ROTATION_LIMIT = 12;
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

    private static char[] generatePassword() {
        Random random = new Random();
        int length = random.nextInt(6, 13);
        char[] password = new char[length];
        for (int i = 0; i < password.length; i++) {
            password[i] = (char) random.nextInt(33, 123);
        }
        return password;
    }

    private static void checkPassword(char[] password) {
        runSpinner();
        if (password == null) return;
        for (char[] inputPassword : passwordBlackList) {
            if (Arrays.equals(inputPassword, password)) {
                System.out.println("Не используйте пароли из списка популярных: " +
                        Arrays.toString(password));
                System.out.println("https://nordpass.com/most-common-passwords-list");
                return;
            }
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
        boolean hasLetters = (hasLowerCaseLetters && hasUpperCaseLetters);
        if (password.length == 0) {
            System.out.print("Пароль не может быть пустым: ");
            printValidateResult(false, password);
            return;
        }
        if (password.length < MIN_LENGTH) {
            System.out.print("Пароль должен быть не менее 8 символов: ");
            printValidateResult(false, password);
            return;
        }
        if (hasDigits && !hasSpecialSymbols && !hasLetters) {
            System.out.print("Пароль содержит только цифры: ");
            printValidateResult(false, password);
            return;
        }
        if (hasLetters && !hasDigits && !hasSpecialSymbols) {
            System.out.print("Пароль содержит только буквы: ");
            printValidateResult(false, password);
            return;
        }
        if (hasSpecialSymbols && !hasDigits && !hasLetters) {
            System.out.print("Пароль содержит только спец. символы: ");
            printValidateResult(false, password);
            return;
        }
        if (hasDigits && hasLetters && !hasSpecialSymbols) {
            System.out.print("Пароль не содержит спец. символы: ");
            printValidateResult(false, password);
            return;
        }
        if (hasDigits && hasSpecialSymbols && !hasLetters) {
            System.out.print("Пароль не содержит буквы нижнего и верхнего регистров: ");
            printValidateResult(false, password);
            return;
        }
        if (!hasDigits && hasSpecialSymbols && hasLetters) {
            System.out.print("Пароль не содержит цифр: ");
            printValidateResult(false, password);
            return;
        }
        if (hasDigits && hasLetters && hasSpecialSymbols) {
            printValidateResult(true, password);
        }
    }

    private static void printValidateResult(boolean passwordStrength, char[] password) {
        String result = (passwordStrength) ?
                ANSI_GREEN + "✓ Password cracked: - " :
                ANSI_RED + "x Strong Password: - ";
        System.out.println(result + Arrays.toString(password) + RESET);
    }

    private static void runSpinner() {
        char[] spins = {'-', '\\', '|', '/'};
        StringBuilder spinner = new StringBuilder();
        for (int i = 0; i < ROTATION_LIMIT; i++) {
            spinner.append("\b").append(spins[i % spins.length]);
            System.out.print(spinner.append("\r"));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
