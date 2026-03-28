package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        String again = "yes";

        while (!"no".equals(again)) {
            Scanner scanner = new Scanner(System.in);
            if ("yes".equals(again)) {
                System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
                String[] expression = scanner.nextLine().split(" ");
                calc.calculate(expression);
                calc.printResult();
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            } else {
                System.out.print("Для закрытия программы " +
                        "ответ должен быть только [yes/no]: ");
            }
            again = scanner.next().toLowerCase();
        }
        System.out.println("Калькулятор закрыт.");
    }
}
