package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class Arrays {
    private static final int LIMIT_NUMBER = 20;
    private static final int MIN_LENGTH = 8;
    private static char[][] passwordBlackList = {
            {'a', 'd', 'm', 'i', 'n'},
            {'q', 'w', 'e', 'r', 't', 'y'},
            {'1', '2', '3', '4', '5', '6'}};

    public static long[] calculateFactorial(int... origin) {
        if (origin == null || origin.length == 0) return null;

        long[] factorials = new long[origin.length];
        for (int i = 0; i < origin.length; i++) {
            long factorial = -1;
            if (origin[i] < 0) {
                System.out.println("Ошибка: факториал " + origin[i] + "! не определен");
            } else if (origin[i] > LIMIT_NUMBER) {
                System.out.println("Ошибка: факториал " + origin[i] + "! слишком велик (максимум 20!)");
            } else {
                factorial = 1;
                for (int j = 2; j <= origin[i]; j++) {
                    factorial *= j;
                }
            }
            factorials[i] = factorial;
        }
        return factorials;
    }

    public static StringBuilder convertToUpperCase(int[] shortAndLongWordIndex, String text) {
        StringBuilder toUpperCase = new StringBuilder();
        if (text == null) {
            System.out.println(toUpperCase.append("null"));
            return null;
        }
        if (text.equals("")) toUpperCase.append("Пустой текст.");
        String[] cleanText = text.split(" ");
        for (int i = 0; i < cleanText.length; i++) {
            if (i >= shortAndLongWordIndex[0] && i <= shortAndLongWordIndex[1]) {
                toUpperCase.append(cleanText[i].toUpperCase()).append(" ");
            } else {
                toUpperCase.append(cleanText[i]).append(" ");
            }
        }
        return toUpperCase;
    }

    public static int[] fillSortedUniqueNumbersArray(int start, int end, int limitNumbers) {
        if (limitNumbers < 1) {
            System.out.println("Ошибка: количество чисел в строке не должно быть < 1 (" + limitNumbers + ")");
            return null;
        }
        if (start > end) {
            System.out.println("Ошибка: левая граница (" + start + ") > правой (" + end + ")");
            return null;
        }
        int length = Math.abs(end - start);
        if (length <= 0) {
            System.out.println("Ошибка: длина массива должна быть > 0 (" + length + ")");
            return null;
        }
        int[] uniqueNumbers = new int[length];
        Random randomNumber = new Random();
        for (int i = 0; i < uniqueNumbers.length; i++) {
            uniqueNumbers[i] = randomNumber.nextInt(start, end + 1);
            for (int j = 0; j < i; j++) {
                if (uniqueNumbers[i] == uniqueNumbers[j]) {
                    i--;
                    break;
                }
            }
        }
        java.util.Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    public static char[] fillArraySortedChars(char leftSide, char rightSide, boolean sortDirection) {
        if (leftSide > rightSide) {
            System.out.println("Ошибка: левая граница (" + leftSide + ") > правой (" + rightSide + ")");
            return null;
        }
        char[] sorted = new char[rightSide - leftSide + 1];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = sortDirection ? leftSide++ : rightSide--;
        }
        return sorted;
    }

    public static float[] fillRandomArray() {
        Random random = new Random();
        float[] randomArray = new float[15];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextFloat();
        }
        return randomArray;
    }

    public static int[] findShortestLongestWordIndex(String text) {
        if (text == null) return null;
        String[] cleanText = text.split(" ");
        int index = 0;
        String shortestWord = null;
        int shortWordIndex = 0;
        String longestWord = null;
        int longWordIndex = 0;
        for (String word : cleanText) {
            word = word.trim();
            if (!word.isEmpty() && !word.matches("\\p{Punct}")) {
                if (shortestWord == null || word.length() < shortestWord.length()) {
                    shortestWord = word;
                    shortWordIndex = index;
                } else if (longestWord == null || word.length() > longestWord.length()) {
                    longestWord = word;
                    longWordIndex = index;
                }
            }
            index++;
        }
        int[] shortAndLongWordIndex = (shortWordIndex > longWordIndex) ?
                new int[]{longWordIndex, shortWordIndex} :
                new int[]{shortWordIndex, longWordIndex};
        return shortAndLongWordIndex;
    }

    public static char[] generatePassword() {
        Random random = new Random();
        int length = random.nextInt(6, 13);
        char[] password = new char[length];
        for (int i = 0; i < password.length; i++) {
            password[i] = (char) random.nextInt(33, 123);
        }
        return password;
    }

    public static boolean checkPassword(char[] password) {
        Console.runSpinner();
        if (password == null) return false;
        for (char[] inputPassword : passwordBlackList) {
            if (java.util.Arrays.equals(inputPassword, password)) {
                System.out.println("Не используйте пароли из списка популярных: " +
                        java.util.Arrays.toString(password));
                System.out.println("https://nordpass.com/most-common-passwords-list");
                return false;
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
            return false;
        }
        if (password.length < MIN_LENGTH) {
            System.out.print("Пароль должен быть не менее 8 символов: ");
            return false;
        }
        if (hasDigits && !hasSpecialSymbols && !hasLetters) {
            System.out.print("Пароль содержит только цифры: ");
            return false;
        }
        if (hasLetters && !hasDigits && !hasSpecialSymbols) {
            System.out.print("Пароль содержит только буквы: ");
            return false;
        }
        if (hasSpecialSymbols && !hasDigits && !hasLetters) {
            System.out.print("Пароль содержит только спец. символы: ");
            return false;
        }
        if (hasDigits && hasLetters && !hasSpecialSymbols) {
            System.out.print("Пароль не содержит спец. символы: ");
            return false;
        }
        if (hasDigits && hasSpecialSymbols && !hasLetters) {
            System.out.print("Пароль не содержит буквы нижнего и верхнего регистров: ");
            return false;
        }
        if (!hasDigits && hasSpecialSymbols && hasLetters) {
            System.out.print("Пароль не содержит цифр: ");
            return false;
        }
        if (hasDigits && hasLetters && hasSpecialSymbols) {
            return true;
        }
        return false;
    }

    public static int[] reverse(int[] transactions) {
        if (transactions == null) return null;
        if (transactions.length == 0) return transactions;

        int length = transactions.length;
        int[] reversedTransactions = new int[length];
        for (int transaction : transactions) {
            reversedTransactions[--length] = transaction;
        }
        return reversedTransactions;
    }

    public static float[] remove(float[] originArray, int index) {
        if (index < 0) {
            System.out.println("Ошибка! Индекс (" + index + ") не может быть меньше 0.");
            return null;
        }
        if (index > originArray.length - 1) {
            System.out.println("Ошибка! Индекс (" + index + ") больше длины массива.");
            return null;
        }

        float valueByIndex = originArray[index];
        float[] changedArray = new float[originArray.length];
        System.arraycopy(originArray, 0, changedArray, 0, originArray.length);
        for (int i = 0; i < originArray.length; i++) {
            if (originArray[i] > valueByIndex) {
                changedArray[i] = 0;
            }
        }
        return changedArray;
    }
}
