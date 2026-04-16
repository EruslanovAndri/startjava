package com.startjava.lesson_2_3_4.calculator;

import java.util.Arrays;

public class Calculator {
    private static final int MAX_LENGTH = 3;

    public static double calculate(String expression) {
        String[] args = expression.split(" ");
        double result = 0;
        try {
            validateExpressionLength(args);
            int number1 = Integer.parseInt(args[0]);
            String sign = args[1];
            int number2 = Integer.parseInt(args[2]);
            if (number2 == 0 && (sign.equals("/") || sign.equals("%"))) {
                throw new ArithmeticException("Деление на ноль запрещено.");
            }
            result = switch (sign) {
                case "+" -> number1 + number2;
                case "-" -> number1 - number2;
                case "*" -> number1 * number2;
                case "^" -> Math.pow(number1, number2);
                case "/" -> (double) number1 / number2;
                case "%" -> Math.floorMod(number1, number2);
                default -> throw new UnsupportedSignException("Ошибка: операция '" + sign +
                        "' не поддерживается.\nДопустимые операции - [+-/*^%]");
            };
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Необходимо ввести только цифры");
        }
        return result;
    }

    private static void validateExpressionLength(String[] args) {
        if (args.length != MAX_LENGTH) {
            throw new IncorrectExpressionException("Введённое выражение '" + Arrays.toString(args) +
                    "' не соответствует необходимому формату.\nПрограмма ожидает: 2 + 2");
        }
    }
}
