package com.startjava.lesson_2_3.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private Player playerOne;
    private Player playerTwo;
    private int secretNumber;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void generateSecretNumber() {
        secretNumber = (int) (Math.random() * 100 + 1);
    }

    public void start() {
        generateSecretNumber();
        System.out.printf("""
                Игра началась!
                Угадай число которое загадал компьютер! %d
                """, secretNumber);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ход первого игрока " + playerOne.getName() + " - ");
            playerOne.setNumber(scanner.nextInt());
            if (playerOne.getNumber() == secretNumber) {
                System.out.println("Победил первый игрок - " + playerOne.getName());
                break;
            }
            System.out.print("Ход второго игрока " + playerTwo.getName() + " - ");
            playerTwo.setNumber(scanner.nextInt());
            if (playerTwo.getNumber() == secretNumber) {
                System.out.println("Победил второй игрок - " + playerTwo.getName());
                break;
            }
        }
    }
}