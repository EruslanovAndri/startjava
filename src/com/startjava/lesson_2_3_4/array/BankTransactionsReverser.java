package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
public class BankTransactionsReverser {
    public static void main(String[] args) {
        int[] transactions1 = new int[0];
        printTransactions(transactions1);
        reverseTransactions(transactions1);
        printTransactions(null);
        reverseTransactions(null);
        int[] transactions2 = new int[] {5};
        printTransactions(transactions2);
        reverseTransactions(transactions2);
        int[] transactions3 = new int[] {6, 8, 9, 1};
        printTransactions(transactions3);
        reverseTransactions(transactions3);
        int[] transactions4 = new int[] {13, 8, 5, 3, 2, 1, 1};
        printTransactions(transactions4);
        reverseTransactions(transactions4);
    }
    private static int[] reverseTransactions(int[] transactions) {
        int[] reversedTransactions = null;
        if (transactions == null) {
            System.out.print("");
        } else {
            int i = transactions.length - 1;
            reversedTransactions = new int[transactions.length];
            for (int transaction : transactions) {
                reversedTransactions[i] = transaction;
                i--;
            }
        }

        return reversedTransactions;
    }
    private static void printTransactions(int[] transactions) {
        int[] reverseTransactions = reverseTransactions(transactions);
        if (transactions == null) {
            System.out.println("null (ошибка в данных)");
        } else if (transactions.length == 0) {
            System.out.println("Массив нулевой длины");
        } else {
            System.out.println("Исходные транзакции: " + Arrays.toString(transactions));
            System.out.println(" В обратном порядке: " + Arrays.toString(reverseTransactions));
        }
    }
}
