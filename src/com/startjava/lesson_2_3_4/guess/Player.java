package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Random;

public class Player {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 100;
    public static final int MAX_ATTEMPT = 5;
    private String name;
    private int[] inputNumber = new int[MAX_ATTEMPT];
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
        if (number < START_RANGE || number > END_RANGE) {
            throw new NumberOutOfRangeException("Число должно входить в отрезок [1, 100]." +
                    "\nПопробуйте еще раз " + name);
        }
        inputNumber[attempt] = number;
        attempt++;
    }

    public int getLastNumber() {
        return inputNumber[attempt - 1];
    }

    public int[] getInputNumbers() {
        return Arrays.copyOf(inputNumber, attempt);
    }

    public void clear() {
        Arrays.fill(inputNumber, 0, attempt, 0);
        attempt = 0;
    }
}