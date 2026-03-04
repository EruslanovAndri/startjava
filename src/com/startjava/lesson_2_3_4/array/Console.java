package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {
    private static final int ROTATION_LIMIT = 12;
    private static final String ANSI_RED = "\u001B[31m"; // Red color
    private static final String ANSI_GREEN = "\u001B[32m"; // Green color
    private static final String RESET = "\033[0m";

    private Console() {
    }

    public static void imitateTypewriter(StringBuilder text) {
        if (text == null) {
            return;
        }
        if (text.equals("")) System.out.print("Ошибка - пустой текст.");

        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

    public static void print(String msg, int[] array) {
        System.out.println(msg + Arrays.toString(array));
    }

    public static void printEmptyString() {
        System.out.println();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printArray(String message, float[] array, String indexMessage, int index) {
        if (array == null) return;
        if (index >= 0 && index < array.length) {
            System.out.println(message);
            for (int i = 0; i < array.length; i++) {
                if (i < 8) {
                    System.out.printf("%6.3f", array[i]);
                } else if (i == 8) {
                    System.out.printf("%n%6.3f", array[i]);
                } else {
                    System.out.printf("%6.3f", array[i]);
                }
            }
            System.out.printf("%s%6.3f", indexMessage, array[index]);
        }
    }

    public static void printFactorialsExpressions(long[] factorials, int... inputNumbers) {
        if (inputNumbers == null) return;
        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < inputNumbers.length; i++) {
            if (inputNumbers[i] == 0 || inputNumbers[i] == 1) {
                expression.append(inputNumbers[i]).append("! = 1").append("\n");
            } else if (factorials[i] != -1) {
                expression.append(inputNumbers[i]).append("! = ");
                for (int j = 1; j < inputNumbers[i]; j++) {
                    expression.append(j).append(" * ");
                }
                expression.append(inputNumbers[i]).append(" = ").append(factorials[i]).append("\n");
            }
        }
        System.out.print(expression);
    }

    public static void printInLimitNumbersRange(int[] sorted, int limitNumbers) {
        if (sorted != null) {
            StringBuilder sortedNumbers = new StringBuilder();
            for (int i = 0; i < sorted.length; i++) {
                sortedNumbers.append(" ").append((i + 1) % limitNumbers == 0 ? "\n" : sorted[i]);
            }
            System.out.println(sortedNumbers);
        }
    }

    public static void printTriangle(char[] inputChars) {
        StringBuilder triangle = new StringBuilder();
        if (inputChars != null) {
            int length = inputChars.length;
            for (int i = 0; i < inputChars.length; i++) {
                triangle.append(" ".repeat(length));
                for (int j = 0; j < 1; j++) {
                    triangle.repeat(inputChars[i], i + j + 1)
                            .append(String.valueOf(inputChars[i]).repeat(i)).append("\n");
                    length--;
                }
            }
            System.out.println(triangle);
        }
    }

    public static void printValidateResult(String good, String bad, boolean isChecked, char[] password) {
        String result = (isChecked) ?
                ANSI_RED + good :
                ANSI_GREEN + bad;
        System.out.println(result + String.valueOf(password) + RESET);
    }

    public static void runSpinner() {
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
