package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        String again = "yes";
        Scanner scanner = new Scanner(System.in);
        while ("yes".equals(again)) {
            game.startGame();
            do {
                System.out.print("Хотите продолжить игру [yes/no]? ");
                again = scanner.next().toLowerCase();
            } while (!"yes".equals(again) && !"no".equals(again));
        }
    }
}
