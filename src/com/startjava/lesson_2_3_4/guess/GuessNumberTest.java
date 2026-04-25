package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите имя первого игрока - ");
        Player playerOne = new Player(scanner.nextLine());
        System.out.print("Введите имя второго игрока - ");
        Player playerTwo = new Player(scanner.nextLine());
        String again = "yes";
        while (!"no".equals(again)) {
            GuessNumber game = new GuessNumber(playerOne, playerTwo);
            if ("no".equals(again)) {
                break;
            }

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