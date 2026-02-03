package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersArray {
    public static void main(String[] args) {
        int[] uniqueNumbers = fillSortedUniqueNumbersArray(-50, -10, 23);
        printInLimitNumbersRange(uniqueNumbers, 23);

        uniqueNumbers = fillSortedUniqueNumbersArray(10, 50, 10);
        printInLimitNumbersRange(uniqueNumbers, 10);

        uniqueNumbers = fillSortedUniqueNumbersArray(-34, -34, 1);
        printInLimitNumbersRange(uniqueNumbers, 1);

        uniqueNumbers = fillSortedUniqueNumbersArray(-1, 2, -3);
        printInLimitNumbersRange(uniqueNumbers, -3);

        uniqueNumbers = fillSortedUniqueNumbersArray(5, -8, 2);
        printInLimitNumbersRange(uniqueNumbers, 2);
    }

    private static int[] fillSortedUniqueNumbersArray(int start, int end, int limitNumbers) {
        if (limitNumbers < 1) {
            System.out.println("Ошибка: количество чисел в строке не должно быть < 1 (" + limitNumbers + ")");
            return null;
        }
        if (start > end) {
            System.out.println("Ошибка: левая граница (" + start + ") > правой (" + end + ")");
            return null;
        }
        int length = (start < 0 && end < 0)
                ? (int) (0.75f * (Math.abs(start) - Math.abs(end)))
                : (int) (0.75f * (end - start));
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
        Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    private static void printInLimitNumbersRange(int[] sorted, int limitNumbers) {
        if (sorted != null) {
            StringBuilder resultStringBuilder = new StringBuilder();
            for (int i = 0; i < sorted.length; i++) {
                resultStringBuilder.append(sorted[i]).append(" ");
                if ((i + 1) % limitNumbers == 0) {
                    resultStringBuilder.append("\n");
                }
            }
            System.out.println(resultStringBuilder);
        }
    }
}
