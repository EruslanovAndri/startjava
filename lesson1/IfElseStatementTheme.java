import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
	public static void main(String[] args) {
		System.out.println("1 Перевод псевдокода на язык JAVA");

		boolean isManGenger = true;

		if (!isManGenger) {
			System.out.println("Мужской пол.");
		} else {
			System.out.println("Женский пол.");
		}

		System.out.println("\n");

		int age = 15;

		if (age > 18) {
			System.out.println("Доступ открыт.");

		} else {
			System.out.println("Доступ запрещен, ваш возраст меньше 18.");
		}

		System.out.println("\n");

		double height = 1.6;

		if (height < 1.8) {
			System.out.println("Ваш рост ниже 1.8 метра.");
		} else {
			System.out.println("Ваш рост выше 1.8 метра.");
		}

		System.out.println("\n");

		System.out.println("2 ПОИСК БОЛЬШЕГО ЧИСЛА ШАГОВ");

		int todaySteps = 1500;

		int yesterdaySteps = 500;

		double everageSteps = (todaySteps + yesterdaySteps) / 2; 

		if (todaySteps > yesterdaySteps) {
			System.out.println("Сегодня было больше шагов чем вчера.");
			System.out.printf( "%s %n %s %d %n %s %d %n %s %.1f",
								"Кол-во шагов:",
								"Сегодня:", todaySteps,
								"Вчера:", yesterdaySteps,
								"Среднее значение:", everageSteps );
		} else if (todaySteps < yesterdaySteps) {
			System.out.println("Вчера было больше шагов чем сегодня.");
			System.out.printf( "%s %n %s %d %n %s %d %n %s %.1f",
								"Кол-во шагов:",
								"Сегодня:", todaySteps,
								"Вчера:", yesterdaySteps,
								"Среднее значение:", everageSteps );	
		} else {
			System.out.println("Кол-во шагов равно.");
			System.out.printf( "%s %n %s %d %n %s %d %n %s %.1f",
								"Кол-во шагов:",
								"Сегодня:", todaySteps,
								"Вчера:", yesterdaySteps,
								"Среднее значение:", everageSteps );
		}

		System.out.println("\n");

		System.out.println("3 ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ");

		System.out.println();

		int guestNumber = 5;

		if (guestNumber >= 0) {

			if (guestNumber == 0) {

			System.out.println("Пока никто не записался на мероприятие!");

			} else if (guestNumber % 2 == 0) {

			System.out.println("Записалось 10 гостей. Можно формировать пары для конкурсов.");
			
			} else if (guestNumber % 2 != 0) {

			System.out.println("Записалось 11 гостей. Нужны индивидуальные задания.");
			
			} 
		} else {

			System.out.println("отрицательное: число не должно быть меньше ноля");

		}

		System.out.println("\n");

		System.out.println("4 ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА");

		System.out.println();

		System.out.println("Первый вариант: с помощью проверки символа на его вхождение в диапазон кодов");

		String name = "(Maria";

		char firstChar = name.charAt(0);

		int numChar = (int) firstChar;

		if (numChar >= 0  && numChar <= 64 || numChar >=91 && numChar <= 96 || numChar >= 123 && numChar <= 127) {

			System.out.printf("%s %s %n %s %s", "Имя: ", name, "начинается с символа -", firstChar);

		} else if (numChar >= 48 && numChar <= 57) {

			System.out.printf("%s %s %n %s %s", "Имя: ", name, "начинается с цифры -", firstChar);
			
		}
		 else if (numChar >= 65 && numChar <= 90) {

			System.out.printf("%s %s %n %s %s", "Имя: ", name, "начинается с большой буквы -", firstChar);

		} else if (numChar >= 97 && numChar <= 122) {

			System.out.printf("%s %s %n %s %s", "Имя: ", name, "нначинается с маленькой буквы -", firstChar);
			
		}

		System.out.println("\n");

		System.out.println("Второй вариант: с помощью методов класса Character, определяющих символы");

		if (Character.isLowerCase(firstChar)) {

			System.out.printf("%s %s %n %s %s", "Имя: ", name, "нначинается с маленькой буквы -", firstChar);

		} else if (Character.isUpperCase(firstChar)) {

			System.out.printf("%s %s %n %s %s", "Имя: ", name, "начинается с большой буквы -", firstChar);
			
		} else if (Character.isDigit(firstChar)) {

			System.out.printf("%s %s %n %s %s", "Имя: ", name, "начинается с цифры -", firstChar);
			
		} else if (Character.isDefined(firstChar)) {
			
			System.out.printf("%s %s %n %s %s", "Имя: ", name, "начинается с символа -", firstChar);

		}

		System.out.println("\n");

		System.out.println("5 ИНВЕНТАРИЗАЦИЯ \n");


		int serialNumber = 234;

		int itemNumber = 24;

		int serialNumberLength = Integer.toString(serialNumber).length();

		int itemNumberLength = Integer.toString(itemNumber).length();


		if (serialNumberLength == itemNumberLength && serialNumber == itemNumber) {

			System.out.printf("%s %d %s","[№",serialNumber,"]: находится на 3 этаже кабинет 2");

		} else if (serialNumberLength == itemNumberLength && serialNumber != itemNumber) {

			System.out.printf("%s %d %s","[№",itemNumber,"]: оборудование не найдено.");
			
		} else if (serialNumberLength > itemNumberLength && (serialNumberLength - itemNumberLength) == 2) {

			
			String msg = (serialNumber % 10 == itemNumber % 10) ? "Частичное совпадение:" : "совпадений нет";

			System.out.printf("""
				%s
				База данных: = [№ %d ]
				Фактический: = [№ __%d ]
				""",msg,serialNumber,itemNumber);

			
		} else if (serialNumberLength > itemNumberLength && (serialNumberLength - itemNumberLength) == 1) {

			String msg = (serialNumber % 10 == itemNumber % 10) ? "Частичное совпадение:" : "совпадений нет";

			msg = (serialNumber / 10 % 10 == itemNumber / 10 % 10)
						 ? "Частичное совпадение:" : "совпадений нет";

			if (msg == "Частичное совпадение:") {

				System.out.printf("""
				%s
				База данных: = [№ %d ]
				Фактический: = [№ _%d ]
				""",msg,serialNumber,itemNumber);

			} else {

				System.out.println("Совпадений не найдено.");

			}			 

			
		}


		System.out.println("\n"); 

		System.out.println("6 ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ % \n");

		System.out.println("Первый вариант");


		float depositAmount = 400_000.79f;

		float fivePersent = depositAmount * 0.05f;

		float sevenPersent = depositAmount * 0.07f;

		float tenPersent = depositAmount * 0.1f;


		if (depositAmount < 100_000.000f) {

			System.out.printf("""
				Сумма депозита: %f
				Cумму начисленного %%: %f
				Итоговую сумму с %%: %f
				""",depositAmount,fivePersent,depositAmount + fivePersent);

		} else if (depositAmount > 100_000  & depositAmount < 300_000) {

			System.out.printf("""
				Сумма депозита: %f
				Cумму начисленного %%: %f
				Итоговую сумму с %%: %f
				""",depositAmount,sevenPersent,depositAmount + sevenPersent);
			
		} else if (depositAmount > 300_000) {

			System.out.printf("""
				Сумма депозита: %f
				Cумму начисленного %%: %f
				Итоговую сумму с %%: %f
				""",depositAmount,tenPersent,depositAmount + tenPersent);
			
		}

		System.out.println("\n Второй вариант");

		var depositAmountBd = new BigDecimal("1150000");

		var fivePersentBd = depositAmountBd.multiply(new BigDecimal("0.05")).setScale(2,RoundingMode.HALF_UP);

		var sevenPersentBd = depositAmountBd.multiply(new BigDecimal("0.07")).setScale(2,RoundingMode.HALF_UP);

		var tenPersentBd = depositAmountBd.multiply(new BigDecimal("0.1")).setScale(2,RoundingMode.HALF_UP);


		if (depositAmountBd.compareTo(new BigDecimal("100000")) < 0) {

			System.out.printf("""
				Сумма депозита: %.2f
				Cумму начисленного %%: %.2f
				Итоговую сумму с %%: %.2f
				""",depositAmountBd,fivePersentBd,depositAmountBd.add(fivePersentBd));

		} else if (depositAmountBd.compareTo(new BigDecimal("100000")) > 0  & depositAmountBd.compareTo(new BigDecimal("300000")) < 0) {

			System.out.printf("""
				Сумма депозита: %.2f
				Cумму начисленного %%: %.2f
				Итоговую сумму с %%: %.2f
				""",depositAmountBd,sevenPersentBd,depositAmountBd.add(sevenPersentBd));
			
		} else if (depositAmountBd.compareTo(new BigDecimal("300000")) > 0) {

			System.out.printf("""
				Сумма депозита: %.2f
				Cумму начисленного %%: %.2f
				Итоговую сумму с %%: %.2f
				""",depositAmountBd,tenPersentBd,depositAmountBd.add(tenPersentBd));
			
		}		

		System.out.println("\n");

		System.out.println("7 ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ\n");

		float history = 59.0f;

		int historyGrade = 0;

		float programming = 61.0f;

		int programmingGrade = 0;

		int cntGrade = 0;

		float persent = 0.0f;

		float averageGrade = 0.0f;

		if (history <= 60) {

			historyGrade += 2;

		} else if (history > 60 & history < 73) {

			historyGrade += 3;

		} else if (history > 73 & history < 91) {

			historyGrade += 4;
			
		} else if (history > 91) {

			historyGrade += 5;
			
		}

		if (programming <= 60) {

			programmingGrade += 2;

		} else if (programming > 60 & programming < 73) {

			programmingGrade += 3;

		} else if (programming > 73 & programming < 91) {

			programmingGrade += 4;
			
		} else if (programming > 91) {

			programmingGrade += 5;
			
		}


		averageGrade = ((float) historyGrade + (float) programmingGrade) / 2; 

		persent = (history + programming) / 2;

		System.out.printf("""
			История: %.1f %%
			Программирование: %.1f %%
			Cредний балл оценок по предметам: %.1f %%
			Cредний %% по предметам: %.1f %%
			""",history,programming,averageGrade,persent);

		System.out.println("\n");

		System.out.println("8 РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ\n");


		var soldOneMonth = new BigDecimal("13025.233");

		var costRent = new BigDecimal("5123.018");

		var costProduction = new BigDecimal("9001.729");

		var period = new BigDecimal("12");

		var profitOneYear = soldOneMonth.multiply(period);

		var costRentOneYear = costRent.multiply(period);

		var costProductionOneYear = costProduction.multiply(period);

		profitOneYear = profitOneYear.subtract(costRentOneYear).subtract(costProductionOneYear);

		if (profitOneYear.compareTo(new BigDecimal("0")) > 0) {

			System.out.printf("""
			Прибыль за год: +%.2f
			""",profitOneYear);

		} else {

			System.out.printf("""
			Прибыль за год: %.2f
			""",profitOneYear);

		}


	}
}