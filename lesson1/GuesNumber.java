import java.util.Random;

public class GuesNumber {
    public static void main(String[] args) {
        Random rnd = new Random();
        int startRange = 1;
        int endRange = 101;
        int hiddenNumber = rnd.nextInt(startRange, endRange);
        int player = rnd.nextInt(startRange, endRange);

        while (player != hiddenNumber) {
            if (player < hiddenNumber) {
                System.out.println(player + " меньше того что загадал компьютер");
                player = rnd.nextInt((startRange + endRange) / 2, endRange);
            } else if (player > hiddenNumber) {
                System.out.println(player + " больше того что загадал компьютер");
                player = rnd.nextInt(startRange, (startRange + endRange) / 2);
            }
        }
        System.out.printf("""
                Вы победили!
                Загаданное число: %d
                Ваше число: %d
                """, hiddenNumber, player);
    }
}