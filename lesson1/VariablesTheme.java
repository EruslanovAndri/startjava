import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariablesTheme {
	public static void main(String[] args) {
		System.out.println("ВЫВОД ASCII-ГРАФИКИ");

	

		System.out.println("первый (с помощью конкатенации)");

		System.out.print("                       " + "/" + "\\" + "\n" + "    " + "j" + "    " + "a" + "  " + "v" + "       " + "v" + " " + "/" + " " + " \\" + "\n" + "    " + "j" + "   " + "a" + " " + "a" + "  " + "v" + "     " + "v" + " " + "/" + "" + "_" + "(" + " " + ")" + "" + "\\" + "\n" + "j" + "   " + "j" + "  " + "aaaaa" + "  " + "V" + "   " + "V" + " " + "/" + "      " + "\\" + "\n" + "  " + "jj" + "  " + "a" + "     " + "a" + "   " + "V" + "  " + "/" + "___" + "/" + "\\" + "___" + "\\" + "\n");

		System.out.println("второй (с помощью текстового блока)");

		String block = 
				"""
						    /\\
				j    a   v     v   /  \\
				j   a a   v   v   /_( )\\	
			j	j  aaaaa   V V	 /      \\
			 jj	  a     a   V   /___/\\___\\
			 	""".indent(4);

		System.out.println(block);



		System.out.println("РАСЧЕТ СТОИМОСТИ ТОВАРА");

		System.out.println();

		System.out.println("Первый вариант решения.");

		float costPen = 105.5f; 

		float costBook = 235.23f;

		int discount = 11;

		float costItems = costPen + costBook;

		float sumDiscount = ( costItems / 100 ) * discount;

		float costDiscountedItem = costItems - sumDiscount;

		System.out.println("Общая стоимость товара = " + costItems);

		System.out.println("Сумма скидки = " + sumDiscount);

		System.out.println("Стоимость товара со скидкой = " + costDiscountedItem);

		System.out.println();

		System.out.println("Второй вариант решения.");

		var costPenBd = new BigDecimal("105.5");

		var costBookBd = new BigDecimal("235.23");

		var discountBd = new BigDecimal("11");

		var costItemsBd = costPenBd.add(costBookBd);

		var sumDiscountBd = costItemsBd.divide(new BigDecimal("100"),2,RoundingMode.HALF_UP).multiply(discountBd);

		var costDiscountedItemBd = costItemsBd.subtract(sumDiscountBd);

		System.out.println("Общая стоимость товара = " + costItemsBd);

		System.out.println("Сумма скидки = " + sumDiscountBd);

		System.out.println("Стоимость товара со скидкой = " + costDiscountedItemBd);

		System.out.println("ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ");

		System.out.println("С помощью третьей переменной");

		int a = 2;

		int b = 5;

		int tmp = 0;

		System.out.println("Переменная А до обмена: " + a);

		System.out.println("Переменная Б до обмена: " + b);

		tmp = a;

		a = b;

		b = tmp;

		System.out.println("Переменная А после обмена: " + a);

		System.out.println("Переменная Б после обмена: " + b);

		System.out.println("С помощью арифметических операций");

		System.out.println("Переменная А до обмена: " + a);

		System.out.println("Переменная Б до обмена: " + b);

		a = a + b;

		b = a - b;

		a = a - b;

		System.out.println("Переменная А после обмена: " + a);

		System.out.println("Переменная Б после обмена: " + b);


		System.out.println("С помощью побитовых операций");

		System.out.println("Переменная А до обмена: " + a);

		System.out.println("Переменная Б до обмена: " + b);

		a = a ^ b;

		b = a ^ b;

		a = a ^ b;

		System.out.println("Переменная А после обмена: " + a);

		System.out.println("Переменная Б после обмена: " + b);











		








	}
}