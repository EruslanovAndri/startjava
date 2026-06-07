package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static final int ROTATION_LIMIT = 50;
    private static final int MAX_ROUNDS = 3;
    private static final int MAX_PLAYERS = 3;
    private static Scanner scanner = new Scanner(System.in);
    private Player[] players;
    private int secretNumber;

    public GuessNumber(Player[] players) {
        this.players = createPlayers();
    }

    public void start() {
        printGameRules();
        int round;
        int currentAttempt;
        for (round = 1; round <= MAX_ROUNDS; round++) {
            Random random = new Random();
            secretNumber = random.nextInt(1, 101);
            for (currentAttempt = 1; currentAttempt <= Player.MAX_ATTEMPT; currentAttempt++) {
                for (Player player : players) {
                    if (makeGuess(player, round, currentAttempt)) {
                        player.addScore();
                        currentAttempt = Player.MAX_ATTEMPT;
                        break;
                    }
                    if (!hasAttempt(player));
                }
            }
            getPlayerInformation(players);
        }
        printGameResult(players);
    }

    private static Player[] createPlayers() {
        Player[] players = new Player[MAX_PLAYERS];
        for (int i = 0; i < MAX_PLAYERS; i++) {
            System.out.print("Введите имя " + (i + 1) + " игрока - ");
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

    private boolean makeGuess(Player player, int round, int currentRound) {
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
        return isGuessed(player, round);
    }

    private boolean isGuessed(Player player, int round) {
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
        if (player.getAttempt() == Player.MAX_ATTEMPT) {
            System.out.println("У " + player.getName() + " закончились попытки.");
            return false;
        }
        return true;
    }

    private void getPlayerInformation(Player[] players) {
        for (Player player : players) {
            showPlayerNumbers(player);
            player.clear();
        }
    }

    private void showPlayerNumbers(Player player) {
        System.out.print("\tИгрок " + player.getName() + " ввел - ");
        for (int number : player.getEnteredNumbers()) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private void printGameResult(Player[] players) {
        int maxScore = findMaxScore(players);
        int countMaxScore = 0;
        int winnerIndex = -1;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getScore() == maxScore) {
                countMaxScore++;
                winnerIndex = i;
            }
        }

        if (countMaxScore == 1) {
            System.out.println("Победитель " + players[winnerIndex].getName());
        } else if (countMaxScore == 2) {
            System.out.println("Ничья!");
        } else {
            System.out.println("Никто не угадал секретное число.");
        }
        for (Player player : players) {
            player.setScore(0);
        }
    }

    private int findMaxScore(Player[] players) {
        int maxScore = players[0].getScore();
        for (int i = 0; i < players.length; i++) {
            if (players[i].getScore() > maxScore) {
                maxScore = players[i].getScore();
            }
        }
        return maxScore;
    }
}