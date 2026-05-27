package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberTest {
    private static final int ROTATION_LIMIT = 10;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Player[] players = initPlayers();
        String again = "yes";
        while (!"no".equals(again)) {
            while (GuessNumber.getRoundCounter() < GuessNumber.getMaxRounds()) {
                GuessNumber game = new GuessNumber(players);
                game.start(players);
            }
            if ("yes".equals(again)) {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            again = scanner.nextLine().trim().toLowerCase();
        }
        System.out.println("Конец игры.");
    }

    private static Player[] initPlayers() {
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
}