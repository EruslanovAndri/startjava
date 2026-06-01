package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static final int ROTATION_LIMIT = 50;
    private static final int MAX_ROUNDS = 3;
    private static Scanner scanner = new Scanner(System.in);
    private static int currentRound;
    private static int round;
    private Player[] players;
    private int[] scores = {0, 0, 0};
    private int secretNumber;

    public GuessNumber() {
        players = createPlayers();
        Random random = new Random();
        secretNumber = random.nextInt(1, 101);
    }

    public void start() {
        printGameRules();
        for (round = 1; round <= MAX_ROUNDS; round++) {
            for (currentRound = 1; currentRound <= Player.MAX_ATTEMPT; currentRound++) {
                System.out.println("Number = " + secretNumber);
                for (int i = 0; i < players.length; i++) {
                    if (makeGuess(players[i])) {
                        printInputNumbers(players);
                        round++;
                        for (Player player : players) {
                            player.clear();
                            currentRound = 0;
                        }
                        break;
                    }

                    if (!hasAttempt(players[i]) && i == players.length - 1) {
                        printInputNumbers(players);
                        for (Player player : players) {
                            player.clear();
                        }
                        break;
                    }
                }
            }
        }
    }

    private static Player[] createPlayers() {
        Player[] players = new Player[3];
        int playerCounter = 0;
        for (int i = 0; i < players.length; i++) {
            playerCounter++;
            System.out.print("Введите имя " + playerCounter + " игрока - ");
            players[i] = new Player(scanner.nextLine());
        }
        runSpinner();
        shufflePlayers(players);
        return players;
    }

    private static void runSpinner() {
        char[] spins = {'-', '\\', '|', '/'};
        StringBuilder spinner = new StringBuilder();
        System.out.println("Определяем последовательность игроков.");
        for (int i = 0; i < ROTATION_LIMIT; i++) {
            spinner.append("\b").append(spins[i % spins.length]);
            System.out.print(spinner.append("\r"));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void shufflePlayers(Player[] players) {
        Random random = new Random();
        for (int i = players.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Player player = players[i];
            players[i] = players[j];
            players[j] = player;
        }
    }

    private void printGameRules() {
        System.out.printf("""
                Игра началась! 
                Угадай число которое загадал компьютер!
                У каждого игрока по %d попыток.
                Победитель будет определен по итогам %d-х раундов.
                """, Player.MAX_ATTEMPT, MAX_ROUNDS);
    }

    private boolean makeGuess(Player player) {
        System.out.print("Раунд № " + round + "\n  Попытка № " + currentRound +
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
                    """, round, player.getName(), secretNumber, player.getAttempt());
            return true;
        }
        String compareResult = (player.getLastNumber() > secretNumber) ? ">" : "<";
        System.out.println("Введенное число " + compareResult + " секретного числа.");
        return false;
    }

    private boolean hasAttempt(Player player) {
        if (currentRound == Player.MAX_ATTEMPT) {
            System.out.println("У " + player.getName() + " закончились попытки.");
            return false;
        }
        return true;
    }

    private void printInputNumbers(Player[] players) {
        for (Player player : players) {
            System.out.print("\tИгрок " + player.getName() + " ввел - ");
            for (int number : player.getEnteredNumbers()) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}