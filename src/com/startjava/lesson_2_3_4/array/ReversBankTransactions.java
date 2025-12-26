package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
public class ReversBankTransactions {
    public static void main(String[] args) {
        int[] transaction1 = new int[0];
        reversBankTransaction(transaction1);
        int[] transaction3 = new int[] {5};
        reversBankTransaction(transaction3);
        int[] transaction4 = new int[] {6, 8, 9, 1};
        reversBankTransaction(transaction4);
        int[] transaction5 = new int[] {13, 8, 5, 3, 2, 1, 1};
        reversBankTransaction(transaction5);
    }
    public static void reversBankTransaction(int[] transaction) {
        if (transaction.length == 0) {
            System.out.println("Массив нулевой длины");
        } else if (transaction.length == 1) {
            System.out.println("Исходные транзакции: " + Arrays.toString(transaction));
            System.out.println(" В обратном порядке: " + Arrays.toString(transaction));
        } else {
            System.out.println("Исходные транзакции: " + Arrays.toString(transaction));
            System.out.print(" В обратном порядке: [" );
            for (int i = transaction.length - 1; i >= 0; i--) {
                if (i > 0) {
                    System.out.print(transaction[i] + ", ");
                } else {
                    System.out.print(transaction[i] + "]\n");
                }
            }
        }
    }
}
