package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumber {
    private static final int MAX_ATTEMPT = 10;
    private Player playerOne;
    private Player playerTwo;
    private int secretNumber;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        generateSecretNumber();
        System.out.printf("""
                Игра началась! 
                Угадай число которое загадал компьютер!
                У каждого игрока по %d попыток.
                """, MAX_ATTEMPT);
        while (true) {
            makeGuess(playerOne);
            if (!isGuessed(playerOne)) {
                compareNumber(playerOne);
            } else {
                break;
            }

            makeGuess(playerTwo);
            if (!isGuessed(playerTwo)) {
                compareNumber(playerTwo);
            } else {
                break;
            }

            if (hasAttempt(playerOne) || hasAttempt(playerTwo)) {
                break;
            }
        }
        showInputNumber(playerOne);
        showInputNumber(playerTwo);
    }

    private void generateSecretNumber() {
        secretNumber = (int) (Math.random() * 100 + 1);
    }

    private static void makeGuess(Player player) {
        player.addAttempt();
        System.out.println("Попытка № " + player.getAttempt());
        System.out.print("Число вводит " + player.getName() + " - ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int number = scanner.nextInt();
            try {
                player.addNumber(number);
                break;
            } catch (NumberOutOfRangeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean isGuessed(Player player) {
        if (player.getInputNumber() == secretNumber) {
            System.out.println(player.getName() + " Угадал число (" + secretNumber +
                    ") c " + player.getAttempt() + "-й попытки.");
            return true;
        }
        return false;
    }

    private void compareNumber(Player player) {
        String compareResult = (player.getInputNumber() > secretNumber) ?
                "Введенное число больше секретного числа." :
                "Введенное число меньше секретного числа.";
        System.out.println(compareResult);
    }

    private boolean hasAttempt(Player player) {
        if (player.getAttempt() == MAX_ATTEMPT) {
            System.out.println("У " + player.getName() + " закончились попытки.");
            return true;
        }
        return false;
    }

    private void showInputNumber(Player player) {
        System.out.print("Игрок " + player.getName() + " ввел - ");
        for (int num : player.inputNumber()) {
            System.out.print(num + " ");
        }
        System.out.println();
        player.cleanInputNumber();
        player.setAttempt(0);
    }
}