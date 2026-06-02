package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String again = "yes";
        GuessNumber game = new GuessNumber();
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