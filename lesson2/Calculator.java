public class Calculator {
    private int number1;
    private int number2;
    private char sing;
    private double result;

    public int setNumber1(int number1) {
        return this.number1 = number1;
    }

    public int getNumber1() {
        return number1;
    }

    public char setSing(char sing) {
        if (sing != '+' && sing != '-' && sing != '*' && sing != '/' && sing != '^' && sing != '%') {
            throw new IllegalArgumentException("Ошибка: операция " + sing + " не поддерживается");
        }
        return this.sing = sing;
    }

    public char getSing() {
        return sing;
    }

    public int setNumber2(int number2) {
        return this.number2 = number2;
    }

    public int getNumber2() {
        return number2;
    }

    public double getResult() {
        return result;
    }

    public void calculate() {
        switch (getSing()) {
            case '+':
                result = getNumber1() + getNumber2();
                break;
            case '-':
                result = getNumber1() - getNumber2();
                break;
            case '*':
                result = getNumber1() * getNumber2();
                break;
            case '/':
                if (getNumber2() == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено ");
                } else {
                    result = (double) getNumber1() / getNumber2();
                }
                break;
            case '^':
                int tmp = 1;
                if (getNumber2() != 0) {
                    for (int i = 0; i < Math.abs(getNumber2()); i++) {
                        tmp *= getNumber1();
                    }
                    result = (getNumber2() > 0) ? tmp : (double) 1 / tmp; 
                }
                break;
            case '%':
                if (getNumber2() == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено ");
                } else {
                    result = (double) getNumber1() % getNumber2();
                }
                break;
            default:
        }
    }
}