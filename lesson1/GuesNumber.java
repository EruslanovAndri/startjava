import java.util.Random;

public class GuesNumber {
	public static void main(String[] args) {

		Random rnd = new Random();

		int startRange = 1;

		int endRange = 101;

	    int	hiddenNumber = rnd.nextInt(startRange,endRange);

		int myNumber = rnd.nextInt(startRange,endRange);


		while (myNumber != hiddenNumber) {

			if (myNumber < hiddenNumber) {

				System.out.println(myNumber + " меньше того что загадал компьютер");

				myNumber = rnd.nextInt((startRange + endRange) / 2,endRange);

			} else if (myNumber > hiddenNumber) {

				System.out.println(myNumber + " больше того что загадал компьютер");

				myNumber = rnd.nextInt(startRange,(startRange + endRange) / 2);
			
			}
		}


		System.out.printf("%s %n %s %,d %n %s %,d "
			,"Вы победили!"
			,"Hidden number was:",hiddenNumber
			,"Your number is:",myNumber);

		
	}
}