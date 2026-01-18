package com.startjava.lesson_2_3_4.array;

public class SymbolSorting {
    public static void main(String[] args) {
        StringBuilder sortedStringBuilder = new StringBuilder();
        sortedStringBuilder = sortSymbols('0', '9', true);
        printSymbols(sortedStringBuilder);

        sortedStringBuilder = sortSymbols('/', '!', false);
        printSymbols(sortedStringBuilder);

        sortedStringBuilder = sortSymbols('A', 'Z', false);
        printSymbols(sortedStringBuilder);
    }

    private static StringBuilder sortSymbols(char leftSide, char rightSide, boolean sortingDirection) {
        if (leftSide > rightSide) {
            System.out.println("Ошибка: левая граница (" + leftSide + ") > правой (" + rightSide + ")");
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (sortingDirection) {
            while (leftSide <= rightSide) {
                stringBuilder.append(leftSide);
                leftSide++;
            }
        } else {
            while (leftSide <= rightSide) {
                stringBuilder.append(rightSide);
                rightSide--;
            }
        }
        return stringBuilder;
    }

    private static void printSymbols(StringBuilder stringBuilder) {
        int repeatTimes = 1;
        String dash = " ";
        int length = stringBuilder.length();
        for (int i = 0; i < stringBuilder.length(); i++) {
            String temp = stringBuilder.substring(i, i + 1);
            for (int j = 0; j < 1; j++) {
                System.out.print(dash.repeat(length));
                length--;
            }
            System.out.print(temp.repeat(repeatTimes));
            System.out.println();
            repeatTimes += 2;
        }
    }
}
