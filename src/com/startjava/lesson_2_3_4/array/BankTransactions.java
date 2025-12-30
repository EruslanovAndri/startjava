package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
public class BankTransactions {
    public static void main(String[] args) {
        int[] transaction1 = new int[0];
        printTransaction(transaction1);
        printTransaction(null);
        int[] transaction2 = new int[] {5};
        printTransaction(transaction2);
        int[] transaction3 = new int[] {6, 8, 9, 1};
        printTransaction(transaction3);
        int[] transaction4 = new int[] {13, 8, 5, 3, 2, 1, 1};
        printTransaction(transaction4);
    }
    public static int[] reversBankTransaction(int[] transaction) {
        int[] reversedTransaction = new int[transaction.length];
        for (int i = 0; i < transaction.length / 2; i++) {
            int start = 0;
            int end = transaction.length - 1;
            while (start < end) {
                int temp = transaction[start];
                reversedTransaction[start] = transaction[end];
                reversedTransaction[end] = temp;
                start++;
                end--;
            }
        }
        return reversedTransaction;
    }
    public static void printTransaction(int[] transaction) {
        if (transaction == null) {
            System.out.println("null");
        } else if (transaction.length == 0) {
            System.out.println("Массив нулевой длины");
        } else if (transaction.length == 1) {
            System.out.println("Исходные транзакции: " + Arrays.toString(transaction));
            System.out.println(" В обратном порядке: " + Arrays.toString(transaction));
        } else {
            System.out.println("Исходные транзакции: " + Arrays.toString(transaction));
            int[] reversedTransaction = reversBankTransaction(transaction);
            System.out.println(" В обратном порядке: " + Arrays.toString(reversedTransaction));
        }
    }
}
