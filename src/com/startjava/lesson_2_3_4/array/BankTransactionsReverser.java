package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class BankTransactionsReverser {
    public static void main(String[] args) {
        int[] transactions1 = new int[0];
        printTransactions(transactions1);
        reverseTransactions(transactions1);
        printTransactions(null);
        System.out.println(" В обратном порядке: " + Arrays.toString(reverseTransactions(null)));
        int[] transactions3 = new int[]{5};
        printTransactions(transactions3);
        System.out.println(" В обратном порядке: " + Arrays.toString(reverseTransactions(transactions3)));
        int[] transactions4 = new int[]{6, 8, 9, 1};
        printTransactions(transactions4);
        System.out.println(" В обратном порядке: " + Arrays.toString(reverseTransactions(transactions4)));
        int[] transactions5 = new int[]{13, 8, 5, 3, 2, 1, 1};
        printTransactions(transactions5);
        System.out.println(" В обратном порядке: " + Arrays.toString(reverseTransactions(transactions5)));
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

    private static void printTransactions ( int[] transactions){
            System.out.println("Исходные транзакции: " + Arrays.toString(transactions));
    }
}
