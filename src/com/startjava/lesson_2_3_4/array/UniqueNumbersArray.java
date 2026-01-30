package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersArray {
    public static void main(String[] args) {
        int[] uniqueNumbersArray = fillArray(-30, -10, 23);
        int[] sortedArray = sortArray(uniqueNumbersArray);
        print(sortedArray);

        uniqueNumbersArray = fillArray(10, 50, 10);
        sortedArray = sortArray(uniqueNumbersArray);
        print(sortedArray);

        uniqueNumbersArray = fillArray(-34, -34, 1);
        sortedArray = sortArray(uniqueNumbersArray);
        print(sortedArray);

        uniqueNumbersArray = fillArray(-1, 2, -3);
        sortedArray = sortArray(uniqueNumbersArray);
        print(sortedArray);

        uniqueNumbersArray = fillArray(5, -8, 2);
        sortedArray = sortArray(uniqueNumbersArray);
        print(sortedArray);
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
        int length = (start < 0 && end < 0) ? start - end : end - start;
        if (length <= 0) {
            System.out.println("Ошибка: длина массива должна быть > 0 (" + length + ")");
            return null;
        }
        int[] uniqueNumbersArray = new int[length];
        Random randomNumber = new Random();
        for (int i = 0; i < limitNumbers; i++) {
            uniqueNumbersArray[i] = randomNumber.nextInt(start, end + 1);
            for (int j = 0; j < i; j++) {
                if (uniqueNumbersArray[i] == uniqueNumbersArray[j]) {
                    i--;
                    break;
                }
            }
        }
        return uniqueNumbersArray;
    }

    private static int[] sortArray(int[] uniqueNumbersArray) {
        if (uniqueNumbersArray == null) return null;
        for (int i = 0; i < uniqueNumbersArray.length; i++) {
            for (int j = 0; j < uniqueNumbersArray.length - i - 1; j++) {
                if (uniqueNumbersArray[j] > uniqueNumbersArray[j + 1]) {
                    int temp = uniqueNumbersArray[j];
                    uniqueNumbersArray[j] = uniqueNumbersArray[j + 1];
                    uniqueNumbersArray[j + 1] = temp;
                }
            }
        }
        return uniqueNumbersArray;
    }

    private static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
