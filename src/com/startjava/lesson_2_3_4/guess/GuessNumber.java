package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class GuessNumber {
    private static final int MAX_ATTEMPT = 10;
    private Player playerOne;
    private Player playerTwo;
    private int secretNumber;
    private int winner;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        int attempt = 1;
        generateSecretNumber();
        System.out.printf("""
                Игра началась! У каждого игрока по %d попыток.
                Угадай число которое загадал компьютер!
                """, MAX_ATTEMPT);
        while (true) {
            System.out.println("Попытка номер " + attempt);
            makeGuess(playerOne, attempt);
            compareNumber(playerOne);
            if (playerOne.getNumber() == secretNumber) {
                System.out.println(playerOne.getName() + " Угадал число (" + secretNumber +
                        ") c " + attempt + "-й попытки.");
                winner = 1;
                break;
            }

            makeGuess(playerTwo, attempt);
            compareNumber(playerTwo);
            if (playerTwo.getNumber() == secretNumber) {
                System.out.println(playerTwo.getName() + " Угадал число (" + secretNumber +
                        ") c " + attempt + "-й попытки.");
                winner = 2;
                break;
            }

            if (attempt == MAX_ATTEMPT) {
                System.out.println("У " + playerTwo.getName() + " закончились попытки.");
                break;
            }
            attempt++;
        }
        showGameResult(attempt);
        playerOne.cleanInputNumber(attempt);
        playerTwo.cleanInputNumber(attempt);
    }

    private void generateSecretNumber() {
        secretNumber = (int) (Math.random() * 100 + 1);
    }

    private void makeGuess(Player player, int attempt) {
        player.setNumber();
        player.addNumber(attempt);
    }

    private void compareNumber(Player player) {
        String compareResult = (player.getNumber() > secretNumber) ?
                "Введенное число больше секретного числа." :
                "Введенное число меньше секретного числа.";
        System.out.println(compareResult);
    }

    private void showGameResult(int attempt) {
        if (winner == 1) {
            playerOne.showInputNumber(attempt);
            playerTwo.showInputNumber(attempt - 1);
        } else if (winner == 2) {
            playerOne.showInputNumber(attempt - 1);
            playerTwo.showInputNumber(attempt);
        } else {
            playerOne.showInputNumber(attempt);
            playerTwo.showInputNumber(attempt);
        }
    }
}