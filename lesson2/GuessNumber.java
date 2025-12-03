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
        this.secretNumber = (int) (Math.random() * 100 + 1);
    }

    public void start() {
        generateSecretNumber();
        System.out.println("Игра началась!");
        System.out.println("Угадай число которое загадал компьютер!" + secretNumber);
        Scanner scanner = new Scanner(System.in);
        while (secretNumber != playerOne.getNumber() || secretNumber != playerTwo.getNumber()) {
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