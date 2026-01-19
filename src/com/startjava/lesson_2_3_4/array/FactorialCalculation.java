package com.startjava.lesson_2_3_4.array;

public class FactorialCalculation {
    private static final int LIMIT_NUMBER = 20;

    public static void main(String[] args) {
        int[] origin = new int[0];
        long[] factorialsResult = calculate(origin);
        printFactorialsExpressions(factorialsResult, origin);

        origin = null;
        factorialsResult = calculate(origin);
        printFactorialsExpressions(factorialsResult, origin);

        origin = new int[]{-5};
        factorialsResult = calculate(origin);
        printFactorialsExpressions(factorialsResult, origin);

        origin = new int[]{21, 0, 7};
        factorialsResult = calculate(origin);
        printFactorialsExpressions(factorialsResult, origin);

        origin = new int[]{1, 20, 5, -3};
        factorialsResult = calculate(origin);
        printFactorialsExpressions(factorialsResult, origin);
    }

    private static long[] calculate(int... origin) {
        if (origin == null || origin.length == 0) return null;

        long[] factorials = new long[origin.length];
        for (int i = 0; i < origin.length; i++) {
            long factorial = -1;
            if (origin[i] < 0) {
                System.out.println("Ошибка: факториал " + origin[i] + "! не определен");
            } else if (origin[i] > LIMIT_NUMBER) {
                System.out.println("Ошибка: факториал " + origin[i] + "! слишком велик (максимум 20!)");
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

    private static void printFactorialsExpressions(long[] factorials, int... origin) {
        if (origin == null) return;
        StringBuilder expression = new StringBuilder();
        int index = 0;
        for (int originNumber : origin) {
            if (originNumber == 0 || originNumber == 1) {
                expression.append(originNumber).append("! = 1");
            } else if (originNumber > 0 && originNumber <= LIMIT_NUMBER) {
                int tempNumber = 1;
                expression.append(originNumber).append("! = ");
                while (tempNumber <= originNumber - 1) {
                    if (originNumber == 0 || originNumber == 1) {
                        expression.append(tempNumber);
                        tempNumber++;
                    } else {
                        expression.append(tempNumber).append(" * ");
                        tempNumber++;
                    }
                }
                expression.append(originNumber).append(" = ").append(factorials[index]);
            }
            index++;
            System.out.println(expression);
            expression.setLength(0);
        }
    }
}
