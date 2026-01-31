package com.startjava.lesson_2_3_4.array;

public class TrianglePrinting {
    public static void main(String[] args) {
        char[] charArray = fillArraySortedChars('0', '9', true);
        printTriangle(charArray);

        charArray = fillArraySortedChars('/', '!', false);
        printTriangle(charArray);

        charArray = fillArraySortedChars('A', 'Z', false);
        printTriangle(charArray);
    }

    private static char[] fillArraySortedChars(char leftSide, char rightSide, boolean sortDirection) {
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

    private static void printTriangle(char[] inputChars) {
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
}
