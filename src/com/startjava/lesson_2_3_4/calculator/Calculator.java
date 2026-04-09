package com.startjava.lesson_2_3_4.calculator;

import java.util.Arrays;

public class Calculator {
    private static final int MAX_LENGTH = 3;

    public static Double calculate(String expression) throws MyException {
        String[] args = expression.split(" ");
        Double result = null;
        try {
            if (args.length != MAX_LENGTH) {
                throw new MyException("Введённое выражение '" + Arrays.toString(args) +
                        "' не соответствует необходимому формату.");
            }
            int number1 = Integer.parseInt(args[0]);
            String sing = args[1];
            int number2 = Integer.parseInt(args[2]);
            if (number2 == 0 && sing.equals("/") || sing.equals("%")) {
                throw new MyException("Деление на ноль запрещено.");
            }
            result = (double) switch (sing) {
                case "+" -> number1 + number2;
                case "-" -> number1 - number2;
                case "*" -> number1 * number2;
                case "^" -> Math.pow(number1, number2);
                case "/" -> (double) number1 / number2;
                case "%" -> Math.floorMod(number1, number2);
                default -> throw new MyException("Ошибка: операция '" + sing + "' не поддерживается.");
            };
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Необходимо ввести только цифры");
        }
        return result;
    }
}
