package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;

public class Player {
    private String name;
    private int number;
    private int[] playerNumber = new int[10];

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
            if (number >= 1 && number <= 100) {
                this.number = number;
                break;
            } else {
                System.out.println("Число должно входить в отрезок [1, 100].\n Попробуйте еще раз:");
            }
        }
    }

    public void addNumber(int attempt) {
        playerNumber[attempt - 1] = getNumber();
    }

    public void showInputNumber(int attempt) {
        int[] inputNumber = Arrays.copyOf(playerNumber, attempt);
        System.out.print("Игрок с именем " + getName() + " ввел - ");
        for (int i = 0; i < inputNumber.length; i++) {
            System.out.print(inputNumber[i] + " ");
        }
        System.out.println();
    }
}