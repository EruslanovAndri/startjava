package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String again = "yes";
        while (!"no".equals(again)) {
            if ("yes".equals(again)) {
                try {
                    String expression = inputExpression();
                    double result = Calculator.calculate(expression);
                    printResult(result, expression);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
                System.out.print("\nХотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            again = scanner.nextLine().toLowerCase().trim();
        }
        System.out.println("Калькулятор закрыт.");
    }

    private static String inputExpression() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
        return scanner.nextLine().trim().replaceAll("\\s+", " ");
    }

    private static void printResult(double result, String expression) {
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.printf("%s %s %s", expression, "=", df.format(result));
    }
}
