import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя первого игрока - ");
        Player playerOne = new Player(scanner.nextLine());

        System.out.print("Введите имя второго игрока - ");
        Player playerTwo = new Player(scanner.nextLine());

        GuessNumber guesNumber = new GuessNumber(playerOne, playerTwo);
        guesNumber.startGuesNumberGame();
    }
}