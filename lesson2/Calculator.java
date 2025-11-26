import java.util.Scanner;

public class Calculator {
    private int number1;
    private int number2;
    private char sing;
    private int result;

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

    public int setResult(int result) {
        return this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void showResult() {
        System.out.printf("%s %d %s %d %s %d %s", "Введенный пример: ",
                getNumber1(), getSing(), getNumber2(), "=", getResult(), "\n");
    }
}