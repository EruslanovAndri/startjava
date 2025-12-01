import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private Player playerOne;
    private Player playerTwo;
    private int rndNumber;

    public GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public int getRndNumber() {
        return rndNumber;
    }
    
    public void setRndNumber() {
        rndNumber = (int) (Math.random() * 100 + 1);
        this.rndNumber = rndNumber;
    }

    public void startGuesNumberGame() {
        String again = "yes";
        boolean finish = true;
        Scanner scanner = new Scanner(System.in);
        do {
            setRndNumber();
            String win = "";
            System.out.println("Игра началась!");
            System.out.println("Угадай число которое загадал компьютер!" + rndNumber);
            do {
                System.out.print("Ход первого игрока " + playerOne.getName() + " - ");
                playerOne.setNumber(scanner.nextInt());
                if (playerOne.getNumber() == rndNumber) {
                    win += playerOne.getName();
                    finish = false;
                    break;
                }
                System.out.print("Ход второго игрока " + playerTwo.getName() + " - ");
                playerTwo.setNumber(scanner.nextInt());
                if (playerTwo.getNumber() == rndNumber) {
                    win += playerTwo.getName();
                    finish = false;
                    break;
                }
            } while (finish);
            System.out.println("Победитель - " + win);
            if (finish == false) {
                do {
                    System.out.print("Хотите продолжить игру? [yes/no]:");
                    again = scanner.next();
                } while (!"yes".equals(again) && !"no".equals(again));
            } 
            if ("yes".equals(again)) {
                finish = true;
            } else {
                finish = false;
            }
        } while (finish);
    }
}