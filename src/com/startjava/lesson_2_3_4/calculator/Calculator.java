package com.startjava.lesson_2_3_4.calculator;

import com.startjava.lesson_2_3_4.guess.NumberOutOfRangeException;

import java.util.Arrays;

public class Calculator {
    private static final int EXPRESSION_LENGTH = 3;

    public static double calculate(String expression) {
        String[] args = expression.split(" ");
        int number1;
        String sign;
        int number2;
        throwIfInvalidExpressionLength(args);
        try {
            number1 = Integer.parseInt(args[0]);
            sign = args[1];
            number2 = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            throw new NumberOutOfRangeException("Необходимо ввести только целые цифры");
        }
        if (number2 == 0 && (sign.equals("/") || sign.equals("%"))) {
            throw new ArithmeticException("Деление на ноль запрещено.");
        }
        return switch (sign) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            case "^" -> Math.pow(number1, number2);
            case "/" -> (double) number1 / number2;
            case "%" -> Math.floorMod(number1, number2);
            default -> throw new UnsupportedSignException("Ошибка: операция '" + sign +
                    "' не поддерживается.\nДопустимые операции - [+-/*^%]");
        };
    }

    private static void throwIfInvalidExpressionLength(String[] args) {
        if (args.length != EXPRESSION_LENGTH) {
            throw new ExpressionLengthException("Введённое выражение '" + Arrays.toString(args) +
                    "' не соответствует необходимому формату.\nПрограмма ожидает: 2 + 2");
        }
    }
}
