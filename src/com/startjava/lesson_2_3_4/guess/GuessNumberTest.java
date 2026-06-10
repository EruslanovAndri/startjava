package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static final int PLAYERS_COUNT = 3;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String again = "yes";
        Player[] players = new Player[PLAYERS_COUNT];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
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
}