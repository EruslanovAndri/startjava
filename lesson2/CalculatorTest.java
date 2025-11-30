import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String again = "yes";

        while ("yes".equals(again)) {
            System.out.print("Введите первое число: ");
            calc.setNumber1(scanner.nextInt());
            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            calc.setSing(scanner.next().charAt(0));
            System.out.print("Введите второе число: ");
            calc.setNumber2(scanner.nextInt());
            calc.calculate();
            System.out.printf("%s %d %s %d %s %f %n", "Введенный пример: ",
                    calc.getNumber1(), calc.getSing(), calc.getNumber2(), "=", calc.getResult());
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                again = scanner.next();
            } while (!"no".equals(again) && !"yes".equals(again)); 
        }
    }
}
