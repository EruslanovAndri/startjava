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
                System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
                String input = scanner.nextLine();
                double result = calc.calculate(input);
                printResult(result, input);
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            again = scanner.nextLine().toLowerCase();
        }
        System.out.println("Калькулятор закрыт.");
    }

    private static void printResult(double result, String input) {
        DecimalFormat df = new DecimalFormat("#.###");
        if (!Double.isNaN(result)) {
            if (result % 1 == 0) {
                System.out.printf("%s %s %d %n", input, "=", (int) result);
            } else {
                System.out.printf("%s %s %s %n", input, "=", df.format(result));
            }
        }
    }
}
