package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private String name;
    private int[] inputNumber = new int[10];
    private int attempt;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAttempt() {
        return attempt;
    }

    public void addNumber(int number) {
        if (number < 1 || number > 100) {
            throw new NumberOutOfRangeException("Число должно входить в отрезок [1, 100]." +
                    "\nПопробуйте еще раз:");
        } else {
            attempt++;
            inputNumber[attempt - 1] = number;
        }
    }

    public int getLastNumber() {
        return inputNumber[attempt - 1];
    }

    public int[] getInputNumber() {
        return Arrays.copyOf(inputNumber, attempt);
    }

    public void clear() {
        Arrays.fill(inputNumber, 0, attempt, 0);
        attempt = 0;
    }
}