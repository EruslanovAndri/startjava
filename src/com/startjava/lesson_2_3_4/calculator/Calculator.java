package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class Calculator {
    private final int length = 3;
    private int number1;
    private String sing;
    private int number2;
    private double result;

    public String[] getExpression() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
        String input = scanner.nextLine().toLowerCase().trim();
        String[] expression = null;
        if (input.length() > length) {
            expression = input.trim().replaceAll("\s+", " ").split(" ");
        }
        return expression;
    }

    public double calculate(String[] expression) {
        number1 = Integer.parseInt(expression[0]);
        sing = expression[1];
        number2 = Integer.parseInt(expression[2]);
        if (number2 == 0 && (sing.equals("/") || sing.equals("%"))) {
            System.out.println("Деление на ноль.");
            return result = Double.NaN;
        }
        switch (sing) {
            case "+":
                result = (double) number1 + number2;
                break;
            case "-":
                result = (double) number1 - number2;
                break;
            case "*":
                result = (double) number1 * number2;
                break;
            case "/":
                result = (double) number1 / number2;
                break;
            case "^":
                result = Math.pow(number1, number2);
                break;
            case "%":
                result = Math.floorMod(number1, number2);
                break;
            default:
        }
        return result;
    }

    public void printResult() {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.###");
        if (!Double.isNaN(result)) {
            if (result % 1 == 0) {
                System.out.printf("%d %s %d %s %d %n", number1, sing, number2, "=", (int) result);
            } else {
                System.out.printf("%d %s %d %s %s %n", number1, sing, number2, "=", df.format(result));
            }
        }
    }
}