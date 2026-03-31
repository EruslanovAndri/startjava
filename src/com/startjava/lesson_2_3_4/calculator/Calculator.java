package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int LENGTH = 3;
    private int number1;
    private String sing;
    private int number2;
    private double result;

    public double calculate(String input) {
        String[] expression = input.split(" ");
        number1 = Integer.parseInt(expression[0]);
        sing = expression[1];
        number2 = Integer.parseInt(expression[2]);
        if (number2 == 0 && (sing.equals("/") || sing.equals("%"))) {
            System.out.println("Деление на ноль запрещено.");
            return result = Double.NaN;
        }
        switch (sing) {
            case "+":
                return result = (double) number1 + number2;
            case "-":
                return result = (double) number1 - number2;
            case "*":
                return result = (double) number1 * number2;
            case "/":
                return result = (double) number1 / number2;
            case "^":
                return result = Math.pow(number1, number2);
            case "%":
                return result = Math.floorMod(number1, number2);
            default:
        }
        return result;
    }
}