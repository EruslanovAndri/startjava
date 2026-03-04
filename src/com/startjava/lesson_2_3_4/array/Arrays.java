package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class Arrays {
    private static final int LIMIT_NUMBER = 20;
    private static final int MIN_LENGTH = 8;
    private static char[][] passwordBlackList = {
            {'a', 'd', 'm', 'i', 'n'},
            {'q', 'w', 'e', 'r', 't', 'y'},
            {'1', '2', '3', '4', '5', '6'}
    };

    private Arrays() {
    }

    public static long[] calculateFactorial(int... inputNumbers) {
        if (inputNumbers == null || inputNumbers.length == 0) return null;

        long[] factorials = new long[inputNumbers.length];
        for (int i = 0; i < inputNumbers.length; i++) {
            long factorial = -1;
            if (inputNumbers[i] < 0) {
                Console.printMessage("Ошибка: факториал " + inputNumbers[i] +
                        "! не определен");
            } else if (inputNumbers[i] > LIMIT_NUMBER) {
                Console.printMessage("Ошибка: факториал " + inputNumbers[i] +
                        " слишком велик (максимум " + LIMIT_NUMBER + ")");
            } else {
                factorial = factorial(inputNumbers[i]);
            }
            factorials[i] = factorial;
        }
        return factorials;
    }

    public static StringBuilder convertToUpperCaseInRange(int[] shortestLongestWordIndex, String text) {
        StringBuilder toUpperCase = new StringBuilder();
        if (text == null) {
            Console.printMessage("null");
            return null;
        }
        if (text.isEmpty()) toUpperCase.append("Пустой текст.");
        String[] cleanText = text.split(" ");
        for (int i = 0; i < cleanText.length; i++) {
            if (i >= shortestLongestWordIndex[0] && i <= shortestLongestWordIndex[1]) {
                toUpperCase.append(cleanText[i].toUpperCase()).append(" ");
            } else {
                toUpperCase.append(cleanText[i]).append(" ");
            }
        }
        return toUpperCase;
    }

    public static boolean checkPassword(char[] password) {
        Console.runSpinner();
        if (password == null) return false;
        for (char[] inputPassword : passwordBlackList) {
            if (java.util.Arrays.equals(inputPassword, password)) {
                Console.printMessage("Не используйте пароли из списка популярных: " +
                        String.valueOf(password) +
                        "\nhttps://nordpass.com/most-common-passwords-list");
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
            Console.printMessage("Пароль не может быть пустым: ");
            return false;
        }
        if (password.length < MIN_LENGTH) {
            Console.printMessage("Пароль должен быть не менее 8 символов: ");
            return false;
        }
        if (hasDigits && !hasSpecialSymbols && !hasLetters) {
            Console.printMessage("Пароль содержит только цифры: ");
            return false;
        }
        if (hasLetters && !hasDigits && !hasSpecialSymbols) {
            Console.printMessage("Пароль содержит только буквы: ");
            return false;
        }
        if (hasSpecialSymbols && !hasDigits && !hasLetters) {
            Console.printMessage("Пароль содержит только спец. символы: ");
            return false;
        }
        if (hasDigits && hasLetters && !hasSpecialSymbols) {
            Console.printMessage("Пароль не содержит спец. символы: ");
            return false;
        }
        if (hasDigits && hasSpecialSymbols && !hasLetters) {
            Console.printMessage("Пароль не содержит буквы нижнего и верхнего регистров: ");
            return false;
        }
        if (!hasDigits && hasSpecialSymbols && hasLetters) {
            Console.printMessage("Пароль не содержит цифр: ");
            return false;
        }
        if (hasDigits && hasLetters && hasSpecialSymbols) {
            return true;
        }
        return false;
    }

    public static long factorial(int number) {
        if (number <= 1) return 1;
        return number * factorial(number - 1);
    }

    public static int[] fillSortedUniqueNumbersArray(int start, int end, int limitNumbers) {
        if (limitNumbers < 1) {
            Console.printMessage("Ошибка: количество чисел в строке не должно быть < 1 (" +
                    limitNumbers + ")");
            return null;
        }
        if (start > end) {
            Console.printMessage("Ошибка: левая граница (" + start + ") > правой (" + end + ")");
            return null;
        }
        int length = Math.abs(end - start);
        if (length <= 0) {
            Console.printMessage("Ошибка: длина массива должна быть > 0 (" + length + ")");
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

    public static int[] findShortestLongestWordIndex(String text) {
        if (text == null) return null;
        String[] cleanText = text.split(" ");
        int index = 0;
        String shortestWord = cleanText[0];
        int shortWordIndex = 0;
        String longestWord = cleanText[0];
        int longWordIndex = 0;
        for (String word : cleanText) {
            word = word.trim();
            if (!word.isEmpty() && !word.matches("\\p{Punct}")) {
                if (word.length() < shortestWord.length()) {
                    shortestWord = word;
                    shortWordIndex = index;
                } else if (word.length() > longestWord.length()) {
                    longestWord = word;
                    longWordIndex = index;
                }
            }

            index++;
        }
        return (shortWordIndex > longWordIndex)
                ? new int[]{longWordIndex, shortWordIndex}
                : new int[]{shortWordIndex, longWordIndex};
    }

    public static char[] generateCharArrayInRange() {
        Random random = new Random();
        int length = random.nextInt(6, 13);
        char[] password = new char[length];
        for (int i = 0; i < password.length; i++) {
            password[i] = (char) random.nextInt(33, 123);
        }
        return password;
    }

    public static char[] makeArraySortedChars(char leftSide, char rightSide, boolean sortDirection) {
        if (leftSide > rightSide) {
            Console.printMessage("\nОшибка: левая граница (" + leftSide +
                    ") > правой (" + rightSide + ")");
            return null;
        }
        char[] sorted = new char[rightSide - leftSide + 1];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = sortDirection ? leftSide++ : rightSide--;
        }
        return sorted;
    }

    public static float[] makeRandomArray(int length) {
        Random random = new Random();
        float[] randomArray = new float[length];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextFloat();
        }
        return randomArray;
    }

    public static int[] reverse(int[] numbers) {
        if (numbers == null || numbers.length == 0) return null;

        int length = numbers.length;
        int[] reversed = new int[length];
        for (int number : numbers) {
            reversed[--length] = number;
        }
        return reversed;
    }

    public static float[] zeroOutElementsBeyond(float[] originArray, int index) {
        if (index < 0) {
            Console.printMessage("Ошибка! Индекс (" + index + ") не может быть меньше 0.");
            return null;
        }
        if (index > originArray.length - 1) {
            Console.printMessage("Ошибка! Индекс (" + index + ") больше длины массива.");
            return null;
        }

        float valueByIndex = originArray[index];
        float[] changedArray = originArray.clone();

        for (int i = 0; i < originArray.length; i++) {
            if (originArray[i] > valueByIndex) {
                changedArray[i] = 0;
            }
        }
        return changedArray;
    }
}
