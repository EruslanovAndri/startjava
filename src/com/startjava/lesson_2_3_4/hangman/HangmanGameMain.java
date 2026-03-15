package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        String again = "yes";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if ("yes".equals(again)) {
                game.start();
                System.out.print("Хотите продолжить игру [yes/no]? ");
                again = scanner.next().toLowerCase();
            } else if ("no".equals(again)) {
                break;
            } else if (!"yes".equals(again) && !"no".equals(again)) {
                System.out.println("Ответ должен быть только yes или no! ");
                System.out.print("Хотите продолжить игру [yes/no]? ");
                again = scanner.next().toLowerCase();
            }
        }
    }
}
