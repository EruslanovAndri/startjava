import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1 ВЫВОД ASCII-СИМВОЛОВ");
        System.out.printf("%s %s %s %n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int i = 33; i <= 47; i++) {
            if (i % 2 != 0) {
                System.out.printf("%-11d %-11c %-10s %n", i, i, Character.getName(i));
            } 
        }
        for (int i = 97; i <= 122; i++) {
            if (i % 2 == 0) {
                System.out.printf("%-11d %-11c %-10s %n", i, i, Character.getName(i));
            }
        }

        System.out.println("\n2 ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР");
        int rows = 5;
        for (int i = 0; i < rows; i++) {
            String str1 = "---------- ";
            for (int j = 0; j < rows - i; j++) {
                str1 += "*";
            }
            str1 += " ";
            for (int j = 0; j < 1 + 2 * i; j++) {
                str1 += "^";
            }
            System.out.print(str1 + "\n");
        }

        System.out.println("\n3 ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ");
        System.out.printf("%3s", "|");
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println("\n--+------------------------");
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%1d %s", i, "|");
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }

        System.out.println("\n4 ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК");
        int limit = 30;
        int count = 0;
        int rowCount = 5;
        for (int i = 1; i < limit; i++) {
            if (i % 2 != 0) {
                System.out.printf("%3d", i);
                count++;
            } 
            if (count == 5) {
                System.out.println();
                count = 0;
            }
            if (count > 0 & i == limit - 1) {
                count = rowCount - count;
                for (int j = 0; j < count; j++) {
                    System.out.printf("%3d", 0);
                }
            }
        }

        System.out.println("\n5 ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX");
        int num1 = 10;
        int num2 = 5;
        int num3 = -1;
        int max = num1;
        int min = num1;

        if (max < num2) max = num2;
        if (max < num3) max = num3;
        if (num2 < min) min = num2;
        if (num3 < min) min = num3;
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
        System.out.println("Интервал чисел между max и min.");
        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n6 РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ");
        int originalNum = 1313231;
        int reversedNumber = 0;
        int counter = 0;
        int currNum = originalNum;
        while (currNum > 0) {
            int remainder = currNum % 10;
            reversedNumber = 10 * reversedNumber + remainder;
            if (remainder == 2) {
                counter++;
            }
            currNum /= 10;
        }
        String odd = (counter % 2 != 0) ? "с нечётным" : "с чётным";
        String palindrome = (reversedNumber == originalNum) ? "палиндром" : "не палиндром";
        if (counter == 0) {
            System.out.printf("%d %s %s %s %n",
                    reversedNumber, "-", palindrome, ", двойки отсутствуют.");
        } else {
            System.out.printf("%d %s %s %s %s %d %s %s %n",
                    reversedNumber, "-", palindrome, odd, "(", counter, ")", "количеством двоек");
        }

        System.out.println("\n 7 ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА");
        int luckyNumber = 400041;
        int tmpLuckyNumber = luckyNumber;
        int luckyNumberLength = String.valueOf(luckyNumber).length();
        int sumLeftSide = 0;
        var leftSideStr = "";
        int sumRightSide = 0;
        var rigthSideStr = "";

        for (int i = 0; i < luckyNumberLength; i++) {
            if (i < luckyNumberLength / 2) {
                int remainder = tmpLuckyNumber % 10;
                sumRightSide += remainder;
                rigthSideStr += Integer.toString(remainder);
                tmpLuckyNumber /= 10;
            } else if (i >= luckyNumberLength / 2) {
                int remainder = tmpLuckyNumber % 10;
                sumLeftSide += remainder;
                leftSideStr += Integer.toString(remainder);
                tmpLuckyNumber /= 10;
            }
        }
        var reversedRightSide = new StringBuilder(rigthSideStr).reverse().toString();
        var reversedLeftSide = new StringBuilder(leftSideStr).reverse().toString();
        String result = (sumLeftSide == sumRightSide) ? "Счастливое число" : "Несчастливое число";
        System.out.printf("%d %s %s %n %s %s %s %d %n %s %s %s %d %n",
                luckyNumber, "-", result, 
                "Сумма цифр:", reversedRightSide, "=", sumRightSide,
                "Сумма цифр:", reversedLeftSide, "=", sumLeftSide);

        System.out.println("\n8 ПРОСТОЙ ГЕНЕРАТОР ПАРОЛЯ");
        StringBuilder password = new StringBuilder();
        Random rnd = new Random();
        int passwordLength = password.length();
        String passwordStrength = "";

        while (passwordLength < rnd.nextInt(5, 15)) {
            char charTmp = (char) rnd.nextInt(33, 122);
            password.append(charTmp);
            passwordLength++;
        }
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toString().toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }
        if (passwordLength >= 8 && hasUpperCase && hasLowerCase && hasSpecialChar && !hasDigit) {
            passwordStrength = "Надежный";
        } else if (passwordLength >= 8 && hasUpperCase && hasDigit && !hasLowerCase && !hasSpecialChar) {
            passwordStrength = "Средний";
        } else {
            passwordStrength = "Слабый";
        }
        System.out.printf("""
                Пароль: %s
                Надежность: %s
                """, password, passwordStrength);
    }
}