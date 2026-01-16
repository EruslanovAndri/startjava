package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class BankTransactionsReverser {
    public static void main(String[] args) {
        int[] original = {};
        int[] reversed = reverse(original);
        printTransactions(original, reversed);

        reversed = null;
        printTransactions(null, reversed);

        original = new int[] {5};
        reversed = reverse(original);
        printTransactions(original, reversed);

        original = new int[] {6, 8, 9, 1};
        reversed = reverse(original);
        printTransactions(original, reversed);

        original = new int[] {13, 8, 5, 3, 2, 1, 1};
        reversed = reverse(original);
        printTransactions(original, reversed);
    }

    private static int[] reverse(int[] transactions) {
        if (transactions == null) return null;
        if (transactions.length == 0) return transactions;

        int length = transactions.length;
        int[] reversedTransactions = new int[length];
        for (int transaction : transactions) {
            reversedTransactions[--length] = transaction;
        }
        return reversedTransactions;
    }

    private static void printTransactions(int[] transactions, int[] reversed) {
        System.out.printf("""
                Исходные транзакции: %s
                 В обратном порядке: %s
                """, Arrays.toString(transactions), Arrays.toString(reversed));
    }
}
