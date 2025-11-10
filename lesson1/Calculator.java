import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Калькулятор");
        System.out.println("Введите первое число: ");
        int num1 = input.nextInt();
        System.out.println("Введите математичиский оператор: ");
        char mathSymbol = input.next().charAt(0);
        System.out.println("Введите второе число: ");
        int num2 = input.nextInt();
        String result = "";

        if (mathSymbol == '+') {
            int tmp = num1 + num2;
            result = Integer.toString(tmp);
        } else if (mathSymbol == '-') {
            int tmp = num1 - num2;
            result = Integer.toString(tmp);
        } else if (mathSymbol == '*') {
            int tmp = num1 * num2;
            result = Integer.toString(tmp);
        } else if (mathSymbol == '^') {
            int tmp = 1;
            int degreeOfNumber = num2;
            while (degreeOfNumber > 0) {
                tmp = tmp * num1;
                degreeOfNumber--;
            }
            result = Integer.toString(tmp);
        } else if (mathSymbol == '/') {
            if (num2 == 0) {
                System.out.println("Деление на ноль.");
            } else {
                double num1Double = num1;
                double num2Double = num2;
                double resultDouble = 0.0f;
                resultDouble = num1Double / num2Double;
                result = Double.toString(resultDouble); 
            }
        } else if (mathSymbol == '%') {
            if (num2 == 0) {
                System.out.println("Деление на ноль."); 
            } else {
                int tmp = num1 % num2;
                result = Integer.toString(tmp);
            }
        }
        System.out.printf("%d %s %d %s %s", num1, mathSymbol, num2, "=", result);
    }
}