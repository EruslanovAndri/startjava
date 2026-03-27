package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTwoTest {
    public static void main(String[] args) {
        CalculatorTwo calculatorTwo = new CalculatorTwo();
        String again = "yes";
        Scanner scanner = new Scanner(System.in);
        while (!"no".equals(again)) {
            if ("yes".equals(again)) {
                String[] expression = calculatorTwo.getExpression();
                double result = calculatorTwo.calculate(expression);
                if (!Double.isNaN(result)) {
                    for (int i = 0; i < expression.length; i++) {
                        System.out.print(expression[i] + " ");
                    }
                    if (result % 1 == 0) {
                        System.out.print("= " + (int) result + "\n");
                    } else {
                        System.out.printf("%s%.3f%n", "= ", result);
                    }
                }
                System.out.print("Хотите продолжить работу калькулятора [yes/no]? ");
            } else {
                System.out.print("Введите только yes или no - ");
            }
            again = scanner.next().toLowerCase();
        }
        System.out.println("Калькулятор закрыт.");
    }
}

