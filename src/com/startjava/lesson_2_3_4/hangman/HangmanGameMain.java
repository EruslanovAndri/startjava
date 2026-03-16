package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        String again = "yes";
        Scanner scanner = new Scanner(System.in);
        while (!"no".equals(again)) {
            if ("yes".equals(again)) {
                game.start();
                System.out.print("Хотите продолжить игру [yes/no]? ");
            } else {
                System.out.print("Введите только yes или no - ");
            }
            again = scanner.next().toLowerCase();
        }
    }
}
