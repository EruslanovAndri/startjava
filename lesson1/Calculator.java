import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Калькулятор");
        System.out.println("Введите первое число: ");
        int num1 = input.nextInt();
        System.out.println("Введите математический оператор: ");
        char mathSing = input.next().charAt(0);
        System.out.println("Введите второе число: ");
        int num2 = input.nextInt();
        String result = "";

        if (mathSing == '+') {
            result = Integer.toString(num1 + num2);
        } else if (mathSing == '-') {
            result = Integer.toString(num1 - num2);
        } else if (mathSing == '*') {
            result = Integer.toString(num1 * num2);
        } else if (mathSing == '^') {
            if (num2 == 0) {
                System.out.println(1);
            }
            int tmp = 1;
            for (int i = 0; i < num2; i++) {
                tmp *= num1;
            }
            result = Integer.toString(tmp);
        } else if (mathSing == '/') {
            if (num2 == 0) {
                System.out.println("Деление на ноль.");
            } else {
                result = Double.toString((double) num1 / num2);
            }
        } else if (mathSing == '%') {
            if (num2 == 0) {
                System.out.println("Деление на ноль."); 
            } else {
                result = Integer.toString(num1 % num2);
            }
        }
        System.out.printf("%d %s %d %s %s", num1, mathSing, num2, "=", result);
    }
}