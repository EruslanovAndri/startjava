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

    public void generateSecretNumber() {
        secretNumber = (int) (Math.random() * 100 + 1);
    }

    public void start() {
        int attempt = 1;
        generateSecretNumber();
        System.out.printf("""
                Игра началась! У каждого игрока по 10 попыток.
                Угадай число которое загадал компьютер! %d
                """, secretNumber);
        while (true) {
            System.out.println("Попытка номер " + attempt);
            playerOne.setNumber();
            playerOne.addNumber(attempt);
            compareNumber(playerOne);
            if (playerOne.getNumber() == secretNumber) {
                System.out.println(playerOne.getName() + " Угадал число (" + secretNumber +
                        ") c " + attempt + "-й попытки.");
                winner = 1;
                break;
            }

            playerTwo.setNumber();
            playerTwo.addNumber(attempt);
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
        cleanInputNumber(playerOne, attempt);
        cleanInputNumber(playerTwo, attempt);
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

    public void cleanInputNumber(Player player, int attempt) {
        Arrays.fill(player.getPlayerNumber(), 0, attempt, 0);
    }
}