package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;

public class GuessNumberTest {
    private static final int PLAYERS_COUNT = 3;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String again = "yes";
        Player[] players = new Player[PLAYERS_COUNT];
        GuessNumber game = new GuessNumber(players);
        while (!"no".equals(again)) {
            if ("yes".equals(again)) {
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