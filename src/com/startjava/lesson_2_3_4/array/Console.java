package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {
    private static final int ROTATION_LIMIT = 12;
    private static final String ANSI_RED = "\u001B[31m"; // Red color
    private static final String ANSI_GREEN = "\u001B[32m"; // Green color
    private static final String RESET = "\033[0m";

    public static void imitateTypewriter(StringBuilder text) {
        if (text == null) {
            return;
        }
        if (text.equals("")) System.out.println("Ошибка - пустой текст.");

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

    public static void printArray(float[] originArray, float[] changedArray, int index) {
        String[] arrayName = {"Исходный массив.", "Измененный массив."};
        float[][] arrays = {originArray, changedArray};
        if (index >= 0 && index < originArray.length) {
            for (int i = 0; i < arrayName.length; i++) {
                System.out.println("\n" + arrayName[i]);
                for (int j = 0; j < 8; j++) {
                    System.out.printf("%6.3f", arrays[i][j]);
                }
                System.out.println();
                for (int j = 8; j < 15; j++) {
                    System.out.printf("%6.3f", arrays[i][j]);
                }
                if (i == 0) {
                    System.out.printf("%n%s%4.3f%n", "Переданный индекс = ", arrays[i][index]);
                }
            }
            System.out.println();
        }
    }

    public static void printFactorialsExpressions(long[] factorials, int... origin) {
        if (origin == null) return;
        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < origin.length; i++) {
            if (origin[i] == 0 || origin[i] == 1) {
                expression.append(origin[i]).append("! = 1").append("\n");
            } else if (factorials[i] != -1) {
                expression.append(origin[i]).append("! = ");
                for (int j = 1; j < origin[i]; j++) {
                    expression.append(j).append(" * ");
                }
                expression.append(origin[i]).append(" = ").append(factorials[i]).append("\n");
            }
        }
        System.out.print(expression);
        expression.setLength(0);
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

    public static void printTransactions(int[] transactions, int[] reversed) {
        System.out.printf("""
                Исходные транзакции: %s
                 В обратном порядке: %s
                """, java.util.Arrays.toString(transactions), Arrays.toString(reversed));
    }

    public static void printValidateResult(boolean isChecked, char[] password) {
        String result = (isChecked) ?
                ANSI_RED + "x Strong Password: - " :
                ANSI_GREEN + "✓ Password cracked: - ";
        System.out.println(result + Arrays.toString(password) + RESET);
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
