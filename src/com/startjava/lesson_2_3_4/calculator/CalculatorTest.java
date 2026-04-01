package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) throws MyException {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();
        String again = "yes";

        while (!"no".equals(again)) {
            if ("yes".equals(again)) {
                System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
                String input = scanner.nextLine();
                double result = calc.calculate(input);
                if (result != 0) {
                    printResult(result, input);
                }
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            again = scanner.nextLine().toLowerCase().trim();
        }
        System.out.println("Калькулятор закрыт.");
    }

    private static void printResult(double result, String input) {
        DecimalFormat df = new DecimalFormat("#.###");
        String cleanInput = input.replaceAll("\\s+", " ").trim();
        if (!Double.isNaN(result)) {
            if (result % 1 == 0) {
                System.out.printf("%s %s %d %n", cleanInput, "=", (int) result);
            } else {
                System.out.printf("%s %s %s %n", cleanInput, "=", df.format(result));
            }
        }
    }
}
