package com.startjava.lesson_2_3_4.array;

import java.util.Scanner;

public class ReversBankTransactions {
    public static void main(String[] args) {
        int length = getArrayLength();
        if (length == 0) {
            System.out.print("Массив нулевой длины");
        } else {
            int[] numbers = new int[length];
            createNumbersArray(numbers);
            printNumbersArray(numbers);
            printReversedNumbersArray(numbers);
        }
    }

    public static int getArrayLength() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        return scanner.nextInt();
    }
    public static void createNumbersArray(int[] numbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер транзакции через пробел: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
    }
    public static void printNumbersArray(int[] numbers) {
        if (numbers.length == 0) {
            System.out.print("Исходные транзакции: []");
            System.out.printf("%n %s", "В обратном порядке: []");
        } else {
            System.out.print("Исходные транзакции: [");
            for (int i = 0; i < numbers.length; i++) {
                if (i < numbers.length - 1) {
                    System.out.print(numbers[i] + ",");
                } else {
                    System.out.print(numbers[i] + "]");
                }
            }
        }
    }
    public static void printReversedNumbersArray(int[] numbers) {
        System.out.printf("%n %s", "В обратном порядке: [");
        for (int i = numbers.length - 1; i >= 0 ; i--) {
            if (i > 0) {
                System.out.print(numbers[i] + ",");
            } else {
                System.out.print(numbers[i] + "]");
            }
        }
    }
}
