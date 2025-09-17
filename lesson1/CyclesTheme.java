import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CyclesTheme {
	public static void main(String[] args) {
		System.out.println("1 ВЫВОД ASCII-СИМВОЛОВ\n");

		System.out.printf("%s %s %s %n","DECIMAL","CHARACTER"," DESCRIPTION");

		for (int i = 33; i < 48; i++) {

			char ch = (char) i;

			if(i % 2 != 0) {
				System.out.printf("%-10d %-10s %-10s %n",i,ch,Character.getName(i));
			}
		}

		System.out.println("\n2 ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР\n");

		int row = 5;

		char dashSymbol = '-';

		char asteriskSymbol = '*';

		char caretSymbol = '^';

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < 10; j++) {

				System.out.print(dashSymbol);
			}
			System.out.println();

		}


		for (int i = row; i > 0; i--) {

			for (int j = 0; j < i; j++) {
				System.out.print(asteriskSymbol);
			}
			System.out.println();
		}

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < row - i - 1; j++) {

				System.out.print(" ");
	
			}

			for (int k = 0; k < 2 * i + 1; k++) {

				System.out.print(caretSymbol);
			}

			System.out.println();
			
		}


		System.out.println("\n");

		System.out.println("\n 3 ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ\n");


		System.out.printf("%3s","|");

		for (int i = 2; i <= 9; i++){

			System.out.printf("%3d",i);


		}

		System.out.println();

		System.out.print("--+------------------------");

		System.out.println();


		for (int i = 2; i <= 9; i++) {

			System.out.printf("%1d %s",i,"|");

			for (int j = 2; j <= 9; j++) {

				System.out.printf("%3d",i * j);

			}

			System.out.println();
		}


		System.out.println("\n 4 ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК \n");

		int limit = 30;

		int cnt = 0;

		int numInRow = 5;


		for (int i = 1; i < limit; i++) {

			if (i % 2 != 0) {

				System.out.printf("%3d",i);

				cnt++;

			} 
			if (cnt == 5) {

				System.out.println();

				cnt = 0;
			}
			if (cnt > 0 & i == limit - 1) {

				cnt = numInRow - cnt;

				for (int j = 0; j < cnt; j++) {

					System.out.printf("%3d",0);
				}

			}

		}

		System.out.println("\n 5 ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX \n");

		int num1 = 10;

		int num2 = 5;

		int num3 = -1;

		int max = num1;

		int min = num1;



		if (max < num2) max = num2;

		if (max < num3) max = num3;


		if (num2 < min) min = num2;

		if (num3 < min) min = num3;

		System.out.println("Max = " + max);

		System.out.println("Min = " + min);

		System.out.println("Интервал чисел между max и min.");

		for (int i = max -1; i > min; i--) {

			System.out.print(i + " ");
		}

		System.out.println();


		System.out.println("\n 6 РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ \n");

		int num =  2234321;

		String strNumber = Integer.toString(num);

		int reversedNumber = 0;

		int counter = 0;

		int tmp = num;

		for (int i = 0; i < strNumber.length(); i++) {

			int remainder = tmp % 10;

			reversedNumber = 10 * reversedNumber + remainder;

			if (remainder == 2) {

				counter++;
			}
	
			tmp /= 10;

		}


		String isOdd = (counter %2 != 0) ? "с нечётным" : "с чётным";

		String isPalindrome = (reversedNumber == num) ? "полиндром" : "не полиндром";

		System.out.printf("%d %s %s %s %s %d %s %s %n",reversedNumber,"-",isPalindrome,isOdd,"(",counter,")","количеством двоек");


		System.out.println("\n 7 ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА \n");


		int isLuckyNumber = 101002;

		int tmpLuckyNumber = isLuckyNumber;

		int luckyNumberLength = String.valueOf(isLuckyNumber).length();

		int sumLeftSide = 0;

		String leftSideStr = "";

		int sumRightSide = 0;

		String rigthSideStr = "";

		for (int i = 0; i < luckyNumberLength / 2; i++) {

			int remainder = tmpLuckyNumber % 10;

			sumRightSide += remainder;

			rigthSideStr += String.valueOf(remainder);

			tmpLuckyNumber /= 10;

		}

		for (int i = luckyNumberLength / 2; i < luckyNumberLength; i++) {

			int remainder = tmpLuckyNumber % 10;

			sumLeftSide += remainder;

			leftSideStr += String.valueOf(remainder);

			tmpLuckyNumber /= 10;

		}

		String result = (sumLeftSide == sumRightSide) ? "Счастливое число" : "Несчастливое число";

		System.out.printf("%d %s %s %n %s %s %s %d %n %s %s %s %d %n"
						,isLuckyNumber,"-",result
							,"Сумма цифр:",rigthSideStr,"=",sumRightSide
							,"Сумма цифр:",leftSideStr,"=",sumLeftSide);



		System.out.println("\n\n 8 ПРОСТОЙ ГЕНЕРАТОР ПАРОЛЯ \n");

		
		String password = "";

		
		int lengthPassword = 0;

		Random rnd = new Random();


		Pattern strongPattern = Pattern.compile("[a-z A-Z !@#$%^&*]{8,}"); // имеет спецсимволы, маленькие и большие буквы > 8 символов

		Matcher strongMatcher = strongPattern.matcher(password);

		Pattern midlePattern  = Pattern.compile("[A-Z 0-9]{8,}");

		Matcher midleMatcher = midlePattern.matcher(password);


		while (lengthPassword < rnd.nextInt(8,10)) {

			char charTmp = (char) rnd.nextInt(33,122);

			password += charTmp;

			lengthPassword++;	
			
		}

		if (strongMatcher.matches()) {

			System.out.printf("%s %s %n %s %s","Пароль",password,"Надежность:","Надежный");

		} else if (midleMatcher.matches()) {

			System.out.printf("%s %s %n %s %s","Пароль",password,"Надежность:","Средний");

		} else {

			System.out.printf("%s %s %n %s %s","Пароль",password,"Надежность:","Слабый");
		}


	}

}