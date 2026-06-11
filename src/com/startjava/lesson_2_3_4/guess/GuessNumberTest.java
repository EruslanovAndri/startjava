package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final int PLAYERS_COUNT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String again = "yes";
        Player[] players = createPlayers(scanner);
        while (!"no".equals(again)) {
            if ("yes".equals(again)) {
                GuessNumber game = new GuessNumber(players);
                game.start();
                System.out.print("Хотите продолжить игру? [yes/no]: ");
            } else {
                System.out.print("Введите корректный ответ [yes/no]: ");
            }
            again = scanner.nextLine().trim().toLowerCase();
        }
        System.out.println("Конец игры.");
    }

    private static Player[] createPlayers(Scanner scanner) {
        Player[] players = new Player[PLAYERS_COUNT];
        for (int i = 0; i < PLAYERS_COUNT; i++) {
            System.out.print("Введите имя " + (i + 1) + " игрока - ");
            players[i] = new Player(scanner.nextLine());
        }
        return players;
    }
}