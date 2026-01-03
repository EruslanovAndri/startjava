package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
public class BankTransactionsReverser {
    public static void main(String[] args) {
        int[] transactions1 = new int[0];
        printTransaction(transactions1);
        printTransaction(null);
        int[] transactions2 = new int[] {5};
        printTransaction(transactions2);
        reversTransaction(transactions2);
        int[] transactions3 = new int[] {6, 8, 9, 1};
        printTransaction(transactions3);
        reversTransaction(transactions3);
        int[] transactions4 = new int[] {13, 8, 5, 3, 2, 1, 1};
        printTransaction(transactions4);
        reversTransaction(transactions4);
    }
    private static void reversTransaction(int[] transactions) {
        int[] reversedTransactions = new int[transactions.length];
        int i = transactions.length - 1;
        for (int transaction : transactions) {
            reversedTransactions[i] = transaction;
            i--;
        }
        System.out.println(" В обратном порядке: " + Arrays.toString(reversedTransactions));
    }
    private static void printTransaction(int[] transactions) {
        if (transactions == null) {
            System.out.println("null");
        } else if (transactions.length == 0) {
            System.out.println("Массив нулевой длины");
        } else {
            System.out.println("Исходные транзакции: " + Arrays.toString(transactions));
        }
    }
}
