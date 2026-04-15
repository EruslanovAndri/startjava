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
            String sing = args[1];
            int number2 = Integer.parseInt(args[2]);
            if (number2 == 0 && sing.equals("/") || sing.equals("%")) {
                throw new ArithmeticException();
            }
            result = switch (sing) {
                case "+" -> number1 + number2;
                case "-" -> number1 - number2;
                case "*" -> number1 * number2;
                case "^" -> Math.pow(number1, number2);
                case "/" -> (double) number1 / number2;
                case "%" -> Math.floorMod(number1, number2);
                default -> throw new InvalidSingException();
            };
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Деление на ноль запрещено.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Введённое выражение '" + Arrays.toString(args) +
                    "' не соответствует необходимому формату.\nПрограмма ожидает: 2 + 2");
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Необходимо ввести только цифры");
        } catch (InvalidSingException e) {
            throw new InvalidSingException("Ошибка: операция '" + args[1] +
                    "' не поддерживается.\nДопустимые операции - [+-/*^%]");
        }
        return result;
    }

    private static void validateExpressionLength(String[] args) {
        if (args.length != MAX_LENGTH) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
