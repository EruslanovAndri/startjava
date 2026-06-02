package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 100;
    public static final int MAX_ATTEMPT = 10;
    private String name;
    private int[] enteredNumbers;
    private int attempt;

    public Player(String name) {
        this.name = name;
        enteredNumbers = new int[MAX_ATTEMPT];
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
        enteredNumbers[attempt] = number;
        attempt++;
    }

    public int getLastNumber() {
        return enteredNumbers[attempt - 1];
    }

    public int[] getEnteredNumbers() {
        return Arrays.copyOf(enteredNumbers, attempt);
    }

    public void clear() {
        Arrays.fill(enteredNumbers, 0, attempt, 0);
        attempt = 0;
    }
}