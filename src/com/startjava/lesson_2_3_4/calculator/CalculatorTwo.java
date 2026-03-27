package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTwo {
    public String[] getExpression() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
        String input = scanner.nextLine().toLowerCase().trim();
        String[] expression = null;
        if (input.length() > 3) {
            expression = input.trim().replaceAll("\s+", " ").split(" ");
        }
        return expression;
    }

    public double calculate(String[] expression) {
        int num1 = Integer.parseInt(expression[0]);
        String mathOperator = expression[1];
        int num2 = Integer.parseInt(expression[2]);
        double result = 0.0;
        switch (mathOperator) {
            case "+":
                result = (double) num1 + num2;
                break;
            case "-":
                result = (double) num1 - num2;
                break;
            case "*":
                result = (double) num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Деление на ноль.");
                    result = Double.NaN;
                } else {
                    result = (double) num1 / num2;
                }
                break;
            case "^":
                result = Math.pow(num1, num2);
                break;
            case "%":
                if (num2 == 0) {
                    System.out.println("Деление на ноль.");
                    result = Double.NaN;
                } else {
                    result = Math.floorMod(num1, num2);
                }
                break;
            default:
        }
        return result;
    }
}

