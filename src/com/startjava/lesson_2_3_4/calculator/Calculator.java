package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private int number1;
    private int number2;
    private char sing;
    private double result;

    public int getNumber1() {
        return number1;
    }

    public int setNumber1(int number1) {
        return this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public int setNumber2(int number2) {
        return this.number2 = number2;
    }

    public char getSing() {
        return sing;
    }

    public char setSing(char sing) {
        if (sing != '+' && sing != '-' && sing != '*' && sing != '/' && sing != '^' && sing != '%') {
            throw new IllegalArgumentException("Ошибка: операция " + sing + " не поддерживается");
        }
        return this.sing = sing;
    }

    public double getResult() {
        return result;
    }

    public void calculate() {
        switch (sing) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number2 == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено ");
                } else {
                    result = (double) number1 / number2;
                }
                break;
            case '^':
                int tmp = 1;
                if (number2 != 0) {
                    for (int i = 0; i < Math.abs(number2); i++) {
                        tmp *= number1;
                    }
                    result = (number2 > 0) ? tmp : (double) 1 / tmp; 
                }
                break;
            case '%':
                if (number2 == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено ");
                } else {
                    result = (double) number1 % number2;
                }
                break;
            default:
        }
    }
}