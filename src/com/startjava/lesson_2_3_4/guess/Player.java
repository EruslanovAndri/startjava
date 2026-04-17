package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;

public class Player {
    private String name;
    private int number;
    private int[] inputNumber = new int[10];

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber() {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print("Число вводит " + name + " - ");
            number = scanner.nextInt();
            try {
                if (number >= 1 && number <= 100) {
                    this.number = number;
                    break;
                } else {
                    throw new NumberOutOfRangeException("Число должно входить в отрезок [1, 100]." +
                            "\nПопробуйте еще раз:");
                }
            } catch (NumberOutOfRangeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void addNumber(int attempt) {
        inputNumber[attempt - 1] = getNumber();
    }

    public void showInputNumber(int attempt) {
        int[] inputNumber = Arrays.copyOf(this.inputNumber, attempt);
        System.out.print("Игрок с именем " + name + " ввел - ");
        for (int num : inputNumber) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void cleanInputNumber(int attempt) {
        Arrays.fill(inputNumber, 0, attempt, 0);
    }
}