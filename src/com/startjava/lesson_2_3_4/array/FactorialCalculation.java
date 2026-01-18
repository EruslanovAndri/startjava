package com.startjava.lesson_2_3_4.array;

/* TODO FactorialCalculation
showFactorials()
- if (origin.length == 0) System.out.println();
какой смысл в такой проверке и таком выводе на консоль?
 С какой дилеммой ты столкнулся, что решил написать такой вывод на консоль?

- число 20 сделай константой. Используй ее везде, где упоминается 20
*/

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
        long[] factorials = null;
        if (origin == null || origin.length == 0) return null;

        factorials = new long[origin.length];
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
        int i = 0;
        for (int num : origin) {
            int temp = 1;
            String tempStr = "";
            while (temp <= num) {
                if (num - temp == 0) {
                    tempStr += temp;
                    temp++;
                } else {
                    tempStr += temp + " * ";
                    temp++;
                }
            }
            expression.append((num == 0 || num == 1)
                    ? num + "! = 1" + "\n"
                    : (num > 0 && num <= LIMIT_NUMBER)
                    ? num + "! = " + tempStr + " = " + factorials[i] + "\n"
                    : "");
            i++;
        }
        System.out.print(expression);
        expression.setLength(0);
    }
}
