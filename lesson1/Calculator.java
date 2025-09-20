import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.ArithmeticException;

public class Calculator {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		System.out.println("Введите пример: ");

		String inputString = input.nextLine().replaceAll("\\s","");

		System.out.println("Введенный пример = "+ inputString);

		int operatorIndex = -1; 


		if (inputString.contains("+")) {

			operatorIndex = inputString.indexOf("+");

		} else if (inputString.contains("-")) {

			operatorIndex = inputString.indexOf("-");
			
		} else if (inputString.contains("*")) {

			operatorIndex = inputString.indexOf("*");
			
		} else if (inputString.contains("/")) {

			operatorIndex = inputString.indexOf("/");
			
		} else if (inputString.contains("%")) {

			operatorIndex = inputString.indexOf("%");
			
		} else if (inputString.contains("^")) {

			operatorIndex = inputString.indexOf("^");
			
		}	

		String leftOperandStr = inputString.substring(0,operatorIndex);

		String rightOperandStr = inputString.substring(operatorIndex + 1,inputString.length());

		System.out.println("Левое число str = " + leftOperandStr + "\nПравое число str = " + rightOperandStr);

		Double leftOperand = Double.parseDouble(leftOperandStr);

		Double rightOperand = Double.parseDouble(rightOperandStr);

		System.out.println("Левое число double = " + leftOperand + "\nПравое число double = " + rightOperand);

		char operator = inputString.charAt(operatorIndex);

		Double result = 0d;

		switch (operator) {

			case '+': result = leftOperand + rightOperand;
				break;

			case '-': result = leftOperand - rightOperand;
				break;

			case '*': result = leftOperand * rightOperand;
				break;

			case '/': if (rightOperand == 0) {

					throw new ArithmeticException("Деление на ноль");

				} else {

					result = leftOperand / rightOperand;

				}

				break;

			case '%': result = leftOperand % rightOperand;

				break;

			case '^': result = leftOperand;

					
				for (int i = 1; i < rightOperand; i++) {

					result *= leftOperand;

				}
				break;

		}

		System.out.printf("%.2f %s %.2f %s %.2f", leftOperand,operator,rightOperand,"=",result);






	}
}