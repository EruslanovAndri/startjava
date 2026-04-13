package com.startjava.lesson_2_3_4.calculator;

import java.util.Arrays;

public class Calculator {
    private static final int MAX_LENGTH = 3;
    private static String exceptionMessage;

    public static String getExceptionMessage() {
        return exceptionMessage;
    }

    public static String resetExceptionMessage() {
        return exceptionMessage = null;
    }

    public static double calculate(String expression) {
        String[] args = expression.split(" ");
        double result = 0;
        try {
            validateExpressionLength(args);
            int number1 = Integer.parseInt(args[0]);
            String sing = args[1];
            int number2 = Integer.parseInt(args[2]);
            if (number2 == 0 && sing.equals("/") || sing.equals("%")) {
                throw new ArithmeticException("Деление на ноль запрещено.");
            }
            result = switch (sing) {
                case "+" -> number1 + number2;
                case "-" -> number1 - number2;
                case "*" -> number1 * number2;
                case "^" -> Math.pow(number1, number2);
                case "/" -> (double) number1 / number2;
                case "%" -> Math.floorMod(number1, number2);
                default -> throw new InvalidSingException("Ошибка: операция '" + sing +
                        "' не поддерживается." + "\nДопустимые операции - [+-/*^%]");
            };
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.err.println(e.getMessage());
            exceptionMessage = e.getMessage();
        } catch (NumberFormatException e) {
            System.err.println("Необходимо ввести только цифры");
            exceptionMessage = e.getMessage();
        } catch (InvalidSingException e) {
            System.err.println(e.getMessage());
            exceptionMessage = e.getMessage();
        }
        return result;
    }

    private static void validateExpressionLength(String[] args) {
        if (args.length != MAX_LENGTH) {
            throw new ArrayIndexOutOfBoundsException("Введённое выражение '" + Arrays.toString(args) +
                    "' не соответствует необходимому формату.\nПрограмма ожидает: 2 + 2");
        }
    }
}
