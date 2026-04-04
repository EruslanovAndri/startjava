package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();
        String again = "yes";

        while (!"no".equals(again)) {
            if ("yes".equals(again)) {
                String expression = getExpression();
                double result = calc.calculate(expression);
                printResult(result, expression);
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            again = scanner.nextLine().toLowerCase().trim();
        }
        System.out.println("Калькулятор закрыт.");
    }

    private static void printResult(double result, String expression) {
        DecimalFormat df = new DecimalFormat("#.###");
        if (result != 0) {
            System.out.printf("%s %s %s %n", expression, "=", df.format(result));
        }
    }

    private static String getExpression() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
        String expression = scanner.nextLine().replaceAll("\\s+", " ").trim();
        return expression;
    }
}
