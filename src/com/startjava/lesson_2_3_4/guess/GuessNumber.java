package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static final int MAX_ATTEMPT = 10;
    private Player playerOne;
    private Player playerTwo;
    private int secretNumber;
    private static Scanner scanner = new Scanner(System.in);

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        Random random = new Random();
        secretNumber = random.nextInt(1, 101);
    }

    public void start() {
        printRulesGame();
        while (true) {
            makeGuess(playerOne);
            if (isGuessed(playerOne)) {
                break;
            }

            makeGuess(playerTwo);
            if (isGuessed(playerTwo)) {
                break;
            }

            if (hasAttempt(playerOne) && hasAttempt(playerTwo)) {
                break;
            }
        }
        showInputNumber(playerOne);
        showInputNumber(playerTwo);
    }

    private void printRulesGame() {
        System.out.printf("""
                Игра началась! 
                Угадай число которое загадал компьютер!
                У каждого игрока по %d попыток.
                """, MAX_ATTEMPT);
    }

    private static void makeGuess(Player player) {
        System.out.print("Попытка № " + player.getAttempt() +
                "\nЧисло вводит " + player.getName() + " - ");
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
        if (player.getLastNumber() == secretNumber) {
            System.out.println(player.getName() + " Угадал число (" + secretNumber +
                    ") c " + player.getAttempt() + "-й попытки.");
            return true;
        }
        String compareResult = (player.getLastNumber() > secretNumber) ?
                "Введенное число больше секретного числа." :
                "Введенное число меньше секретного числа.";
        System.out.println(compareResult);
        return false;
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
        for (int number : player.getInputNumber()) {
            System.out.print(number + " ");
        }
        System.out.println();
        player.clear();
    }
}