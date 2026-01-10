package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class BankTransactionsReverser {
    public static void main(String[] args) {
        int[] transactions1 = new int[0];
        int[] reverse1 = reverseTransactions(transactions1);
        printTransactions(transactions1, reverse1);
        int[] reverseNull = reverseTransactions(null);
        printTransactions(null, reverseNull);
        int[] transactions3 = new int[]{5};
        int[] reverse3 = reverseTransactions(transactions3);
        printTransactions(transactions3, reverse3);
        int[] transactions4 = new int[]{6, 8, 9, 1};
        int[] reverse4 = reverseTransactions(transactions4);
        printTransactions(transactions4, reverse4);
        int[] transactions5 = new int[]{13, 8, 5, 3, 2, 1, 1};
        int[] reverse5 = reverseTransactions(transactions5);
        printTransactions(transactions5, reverse5);
    }

    private static int[] reverseTransactions(int[] transactions) {
        if (transactions != null) {
            if (transactions.length != 0) {
                System.out.print("");
            } else {
                System.out.println("массив нулевой длины");
            }
        } else {
            return null;
        }
        int i = transactions.length;
        int[] reversedTransactions = new int[transactions.length];
        for (int transaction : transactions) {
            --i;
            reversedTransactions[i] = transaction;
        }
        return reversedTransactions;
    }

    private static void printTransactions(int[] transactions, int[] reversedTransactions) {
        System.out.println("Исходные транзакции: " + Arrays.toString(transactions));
        System.out.println(" В обратном порядке: " + Arrays.toString(reversedTransactions));
    }
}
