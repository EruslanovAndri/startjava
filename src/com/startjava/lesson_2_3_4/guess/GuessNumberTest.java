package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя первого игрока - ");
        Player playerOne = new Player(scanner.nextLine());

        System.out.print("Введите имя второго игрока - ");
        Player playerTwo = new Player(scanner.nextLine());

        GuessNumber game = new GuessNumber(playerOne, playerTwo);
        String again = "yes";
        while ("yes".equals(again)) {
            game.start();
            do {
                System.out.print("Хотите продолжить игру? [yes/no]:");
                again = scanner.next();
            } while (!"yes".equals(again) && !"no".equals(again));
        }
    }
}