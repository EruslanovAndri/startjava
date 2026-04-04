package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int MAX_LENGTH = 3;

    public static double calculate(String expression) {
        String[] args = expression.split(" ");
        double result = 0.0;
        try {
            if (args.length > MAX_LENGTH) {
                throw new IndexOutOfBoundsException("Введённое выражение длиннее необходимого.");
            }
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
                default -> throw new IllegalStateException("Знак не поддерживается для выражения " + sing);
            };
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Необходимо ввести цифры.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
