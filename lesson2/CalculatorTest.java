import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String question = "yes";
        while (question.equals("yes") || !question.equals("no")) {
            calc.setNumber1();
            calc.setSing();
            calc.setNumber2();
            switch (calc.getSing()) {
                case '+':
                    calc.setResult(calc.getNumber1() + calc.getNumber2());
                    break;
                case '-':
                    calc.setResult(calc.getNumber1() - calc.getNumber2());
                    break;
                case '*':
                    calc.setResult(calc.getNumber1() * calc.getNumber2());
                    break;
                case '/':
                    if (calc.getNumber2() == 0) {
                        System.out.println("Ошибка: деление на ноль запрещено");
                        calc.setResult(0);
                    } else {
                        calc.setResult(calc.getNumber1() / calc.getNumber2());
                    }
                    break;
                case '^':
                    int positiveExponentiation = 1;
                    int negativeExponentiation = 1;
                    if (calc.getNumber1() == 0) {
                        calc.setResult(0);
                    } else if (calc.getNumber1() != 0 && calc.getNumber2() < 0) {
                        for (int i = calc.getNumber2(); i < 0; i++) {
                            negativeExponentiation *= calc.getNumber1();
                        }
                        calc.setResult(positiveExponentiation / negativeExponentiation);
                    } else if (calc.getNumber2() == 0) {
                        calc.setResult(1);
                    } else {
                        for (int i = 0; i < calc.getNumber2(); i++) {
                            positiveExponentiation *= calc.getNumber1();
                        }
                        calc.setResult(positiveExponentiation);
                    }
                    break;
                case '%':
                    calc.setResult(calc.getNumber1() % calc.getNumber2());;
                    break;
                default:
            }
            calc.showResult();
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            question = scanner.next();
        }
    }
}
