package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static int maxRounds = 3;
    private static Scanner scanner = new Scanner(System.in);
    private static int currentStepCounter;
    private static int roundCounter;
    private Player[] players;
    private int secretNumber;

    public GuessNumber(Player[] players) {
        this.players = players;
        Random random = new Random();
        secretNumber = random.nextInt(1, 101);
    }

    public static int getMaxRounds() {
        return GuessNumber.maxRounds;
    }

    public static int getRoundCounter() {
        return GuessNumber.roundCounter;
    }

    public void start(Player[] players) {
        roundCounter++;
        if (roundCounter == 1) {
            printGameRules();
        }
        boolean guessed = true;
        while (guessed) {
            for (Player player : players) {
                if (makeGuess(player)) {
                    guessed = false;
                    break;
                }
                if (!hasAttempt(player)) {
                    currentStepCounter++;
                    if (currentStepCounter == players.length) {
                        break;
                    }
                    guessed = false;
                }
            }
        }
        for (Player player : players) {
            printInputNumbers(player);
            player.clear();
        }
    }

    private void printGameRules() {
        System.out.printf("""
                Игра началась! 
                Угадай число которое загадал компьютер!
                У каждого игрока по %d попыток.
                Победить будет определен по итогам %d-х раундов.
                """, Player.MAX_ATTEMPT, maxRounds);
    }

    private boolean makeGuess(Player player) {
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
        return isGuessed(player);
    }

    private boolean isGuessed(Player player) {
        if (player.getLastNumber() == secretNumber) {
            System.out.printf("""
                   В раунде %d победил %s
                   он угадал число (%d) c %s-й попытки.
                    """, roundCounter, player.getName(), secretNumber, player.getAttempt());
            return true;
        }
        String compareResult = (player.getLastNumber() > secretNumber) ?
                "Введенное число больше секретного числа." :
                "Введенное число меньше секретного числа.";
        System.out.println(compareResult);
        return false;
    }

    private boolean hasAttempt(Player player) {
        if (player.getAttempt() == Player.MAX_ATTEMPT) {
            System.out.println("У " + player.getName() + " закончились попытки.");
            if (currentStepCounter == Player.MAX_ATTEMPT) {
                System.out.println(currentStepCounter);
                System.out.printf("В %d раунде никто не угадал число.\n", roundCounter);
            }
            return false;
        }
        return true;
    }

    private void printInputNumbers(Player player) {
        System.out.print("\tИгрок " + player.getName() + " ввел - ");
        for (int number : player.getInputNumbers()) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}