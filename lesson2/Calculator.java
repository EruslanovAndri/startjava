import java.util.Scanner;

public class Calculator {
    private int number1;
    private int number2;
    private char sing;

    public int setNumber1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        return this.number1 = scanner.nextInt();
    }

    public int getNumber1() {
        return number1;
    }

    public char setSing() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
        char sing = scanner.next().charAt(0);
        if (sing != '+' && sing != '-' && sing != '*' && sing != '/' && sing != '^' && sing != '%') {
            throw new IllegalArgumentException("Ошибка: операция " + sing + " не поддерживается");
        }
        this.sing = sing;
        return this.sing;
    }

    public char getSing() {
        return sing;
    }

    public int setNumber2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите второе число: ");
        return this.number2 = scanner.nextInt();
    }

    public int getNumber2() {
        return number2;
    }

    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        String question = "yes";
        int calculationResult = 0;
        while (question.equals("yes") || !question.equals("no")) {
            setNumber1();
            setSing();
            setNumber2();
            switch (getSing()) {
                case '+':
                    calculationResult = getNumber1() + getNumber2();
                    break;
                case '-':
                    calculationResult = getNumber1() - getNumber2();
                    break;
                case '*':
                    calculationResult = getNumber1() * getNumber2();
                    break;
                case '/':
                    if (getNumber2() == 0) {
                        System.out.println("Ошибка: деление на ноль запрещено");
                    } else {
                        calculationResult = getNumber1() / getNumber2();
                    }
                    break;
                case '^':
                    int positiveExponentiation = 1;
                    int negativeExponentiation = 1;
                    if (getNumber1() == 0) {
                        calculationResult = 0;
                    } else if (getNumber1() != 0 && getNumber2() < 0) {
                        for (int i = getNumber2(); i < 0; i++) {
                            negativeExponentiation *= getNumber1();
                        }
                        calculationResult = calculationResult / negativeExponentiation;
                    } else if (getNumber2() == 0) {
                        calculationResult = 1;
                    } else {
                        for (int i = 0; i < getNumber2(); i++) {
                            positiveExponentiation *= getNumber1();
                        }
                        calculationResult = positiveExponentiation;
                    }
                    break;
                case '%':
                    calculationResult = getNumber1() % getNumber2();
                    break;
                default:
            }
            System.out.printf("%s %d %s %d %s %d %s", "Введенный пример: ",
                    getNumber1(), getSing(), getNumber2(), "=", calculationResult, "\n");
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            question = scanner.next();
        }
    }
}