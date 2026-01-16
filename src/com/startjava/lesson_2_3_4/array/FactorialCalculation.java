package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class FactorialCalculation {
    public static void main(String[] args) {
        int[] origin = new int[0];
        long[] factorialsResult = calculate(origin);
        showFactorials(factorialsResult, origin);

        origin = null;
        factorialsResult = calculate(origin);
        showFactorials(factorialsResult, origin);

        origin = new int[]{-5};
        factorialsResult = calculate(origin);
        showFactorials(factorialsResult, origin);

        origin = new int[]{21, 0, 7};
        factorialsResult = calculate(origin);
        showFactorials(factorialsResult, origin);

        origin = new int[]{1, 20, 5, -3};
        factorialsResult = calculate(origin);
        showFactorials(factorialsResult, origin);
    }

    private static long[] calculate(int... origin) {
        long[] factorials = null;
        if (origin == null) return factorials;
        if (origin.length == 0) return factorials;

        factorials = new long[origin.length];
        for (int i = 0; i < origin.length; i++) {
            long factorial = -1;
            if (origin[i] < 0) {
                System.out.println("Ошибка: факториал " + origin[i] + " ! не определен");
            } else if (origin[i] > 20) {
                System.out.println("Ошибка: факториал " + origin[i] + " ! слишком велик (максимум 20!)");
            } else {
                factorial = 1;
                for (int j = 2; j <= origin[i]; j++) {
                    factorial *= j;
                }
            }
            factorials[i] = factorial;
        }
        return factorials;
    }

    private static void showFactorials(long[] factorials, int... origin) {
        if (origin == null) return;
        if (origin.length == 0) System.out.println();
        StringBuilder outputResult = new StringBuilder();
        int i = 0;
        for (int num : origin) {
            int temp = 1;
            StringBuilder tempStr = new StringBuilder();
            while (temp <= num) {
                if (num - temp == 0) {
                    tempStr.append(temp);
                    temp++;
                } else {
                    tempStr.append(temp).append(" * ");
                    temp++;
                }
            }
            outputResult.append((num == 0 || num == 1)
                    ? num + "! = 1" + "\n"
                    : (num > 0 && num <= 20)
                    ? num + "! = " + tempStr.append(" = ").append(factorials[i]).append("\n")
                    : "");
            i++;
        }
        System.out.println(outputResult);
    }
}
