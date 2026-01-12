package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class BankTransactionsReverser {
    public static void main(String[] args) {
        int[] original = new int[]{21, 13 , 1, 1, 3};
        int[] reversed = reverse(original);
        printTransactions(reversed, original);

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
                 В обратном порядке: %s""", Arrays.toString(transactions), Arrays.toString(reversed));
    }
}
