package com.startjava.hangman;

public class HangmanGameMain extends HangmanGame {

    public static void main(String[] args) {
        String again = "yes";
        while ("yes".equals(again)) {
            startGame();
            do {
                System.out.print("Хотите продолжить игру [yes/no]? ");
                again = scanner.next().toLowerCase();
            } while (!"yes".equals(again) && !"no".equals(again));
        }
    }
}
