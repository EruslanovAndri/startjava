package com.startjava.lesson_2_3_4.array;

public class Triangle {
    public static void main(String[] args) {
        char[] charArray = sortSymbols('0', '9', true);
        printTriangle(charArray);

        charArray = sortSymbols('/', '!', false);
        printTriangle(charArray);

        charArray = sortSymbols('A', 'Z', false);
        printTriangle(charArray);
    }

    private static char[] sortSymbols(char leftSide, char rightSide, boolean sortDirection) {
        if (leftSide > rightSide) {
            System.out.println("Ошибка: левая граница (" + leftSide + ") > правой (" + rightSide + ")");
            return null;
        }
        char[] sortedCharArray = new char[rightSide - leftSide + 1];
        for (int i = 0; i < sortedCharArray.length; i++) {
            sortedCharArray[i] = (sortDirection) ? leftSide++ : rightSide--;
        }
        return sortedCharArray;
    }

    private static void printTriangle(char[] charArray) {
        StringBuilder triangle = new StringBuilder();
        if (charArray == null) {
            System.out.println(triangle);
        } else {
            int length = charArray.length;
            for (int i = 0; i < charArray.length; i++) {
                triangle.append(" ".repeat(length));
                for (int j = 0; j < 1; j++) {
                    triangle.repeat(charArray[i], i + j + 1)
                            .append(String.valueOf(charArray[i]).repeat(i)).append("\n");
                    length--;
                }
            }
            System.out.println(triangle);
        }
    }
}
