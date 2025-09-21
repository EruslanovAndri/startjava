import java.lang.ArithmeticException;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите пример: ");

        String inputString = input.nextLine().replaceAll("\\s", "");

        System.out.println("Введенный пример = " + inputString);

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

        String leftOperandStr = inputString.substring(0, operatorIndex);

        String rightOperandStr = inputString.substring(operatorIndex + 1, inputString.length());

        Double leftOperand = Double.parseDouble(leftOperandStr);

        Double rightOperand = Double.parseDouble(rightOperandStr);

        char operator = inputString.charAt(operatorIndex);

        Double result = 0d;

        switch (operator) {
            case '+': result = leftOperand + rightOperand;
                break;
            case '-':result = leftOperand - rightOperand;
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
            default: System.out.println("Yes");;
        }
        System.out.printf("%.2f %s %.2f %s %.2f", leftOperand, operator, rightOperand, "=", result);
    }
}