package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int MAX_LENGTH = 3;
    private static int number1;
    private static String sing;
    private static int number2;

    public static double calculate(String input) throws CalculatorExceptions {
        String[] expression = input.split(" ");
        try {
            if (expression.length > MAX_LENGTH) {
                throw new IndexOutOfBoundsException("Введённое выражение длинее необходимого.");
            }
            number1 = Integer.parseInt(expression[0]);
            sing = expression[1];
            number2 = Integer.parseInt(expression[2]);
            if (number2 == 0 && sing.equals("/") || sing.equals("%")) {
                throw new ArithmeticException("Деление на ноль запрещено.");
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
                default: {
                    throw new IllegalArgumentException("Знак не поддерживается для выражения " + input);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return 0.0;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return 0.0;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0.0;
        }
    }
}
