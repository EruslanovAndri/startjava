package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersArray {
    public static void main(String[] args) {
        int[] uniqueNumbers = fillArray(-50, -10, 23);
        int[] sorted = sortArray(uniqueNumbers);
        printInLimitNumbersRange(sorted, 23);

        uniqueNumbers = fillArray(10, 50, 10);
        sorted = sortArray(uniqueNumbers);
        printInLimitNumbersRange(sorted, 10);

        uniqueNumbers = fillArray(-34, -34, 1);
        sorted = sortArray(uniqueNumbers);
        printInLimitNumbersRange(sorted, 1);

        uniqueNumbers = fillArray(-1, 2, -3);
        sorted = sortArray(uniqueNumbers);
        printInLimitNumbersRange(sorted, -3);

        uniqueNumbers = fillArray(5, -8, 2);
        sorted = sortArray(uniqueNumbers);
        printInLimitNumbersRange(sorted, 2);
    }

    private static int[] fillArray(int start, int end, int limitNumbers) {
        if (limitNumbers < 1) {
            System.out.println("Ошибка: количество чисел в строке не должно быть < 1 (" + limitNumbers + ")");
            return null;
        }
        if (start > end) {
            System.out.println("Ошибка: левая граница (" + start + ") > правой (" + end + ")");
            return null;
        }
        int length = (start < 0 && end < 0) ? (int) (0.75f * (end - start)) : (int) (0.75f * (end - start));
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
        return uniqueNumbers;
    }

    private static int[] sortArray(int[] uniqueNumbers) {
        if (uniqueNumbers == null) return null;
        Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    private static void printInLimitNumbersRange(int[] sorted, int limitNumbers) {
        if (sorted != null) {
            if (limitNumbers > sorted.length) {
                for (int i = 0; i < sorted.length; i++) {
                    System.out.print(sorted[i] + " ");
                }
                System.out.println();
            } else {
                for (int i = 0; i < sorted.length; i++) {
                    System.out.print(sorted[i] + " ");
                    if ((i + 1) % limitNumbers == 0) {
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
    }
}
