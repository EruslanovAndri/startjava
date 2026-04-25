package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private static final int START_RAGE = 1;
    private static final int END_RAGE = 100;
    private static final int ONE = 1;
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
        if (number < START_RAGE || number > END_RAGE) {
            throw new NumberOutOfRangeException("Число должно входить в отрезок [1, 100]." +
                    "\nПопробуйте еще раз:");
        } else {
            attempt++;
            inputNumber[attempt - ONE] = number;
        }
    }

    public int getLastNumber() {
        return inputNumber[attempt - ONE];
    }

    public int[] getInputNumber() {
        return Arrays.copyOf(inputNumber, attempt);
    }

    public void clear() {
        Arrays.fill(inputNumber, 0, attempt, 0);
        attempt = 0;
    }
}