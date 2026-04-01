package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int MAX_LENGTH = 5;
    private static int number1;
    private static String sing;
    private static int number2;

    public static double calculate(String input) {
        String[] expression;
        if (input.length() > MAX_LENGTH) {
            expression = input.replaceAll("\\s+", " ").trim().split(" ");
        } else {
            expression = input.split(" ");
        }

        try {
            number1 = Integer.parseInt(expression[0]);
            sing = expression[1];
            number2 = Integer.parseInt(expression[2]);
            if (sing.equals("+") || sing.equals("-") || sing.equals("*") ||
                    sing.equals("/") || sing.equals("^") || sing.equals("%")) {
                sing = expression[1];
            } else {
                throw new MyException("Знак не поддерживается для выражения " + input);
            }
            if (number2 == 0 && sing.equals("/") || sing.equals("%")) {
                throw new MyException("Деление на ноль запрещено.");
            }
            switch (sing) {
                case "+":
                    return number1 + number2;
                case "-":
                    return number1 - number2;
                case "*":
                    return number1 * number2;
                case "/":
                    return (double) number1 / number2;
                case "^":
                    return Math.pow(number1, number2);
                case "%":
                    return Math.floorMod(number1, number2);
                default:
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0.0;
        }
        return 0.0;
    }
}

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}