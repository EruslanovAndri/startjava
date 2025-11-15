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
        int originalNum = 1233204;
        int reversedNum = 0;
        int counter = 0;
        int currNum = originalNum;
        while (currNum > 0) {
            int remainder = currNum % 10;
            reversedNum = 10 * reversedNum + remainder;
            if (remainder == 2) {
                counter++;
            }
            currNum /= 10;
        }
        String odd = (counter % 2 != 0) ? "с нечётным" : "с чётным";
        String palindrome = (reversedNum == originalNum) ? "палиндром" : "не палиндром";
        if (counter == 0) {
            System.out.printf("%d %s %s %d %n",
                    reversedNum, "-", palindrome, 0);
        } else {
            System.out.printf("%d %s %s %s %s %d %s %s %n",
                    reversedNum, "-", palindrome, odd, "(", counter, ")", "количеством двоек");
        }

        System.out.println("\n 7 ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА");
        int luckyNum = 101002;
        int halfLuckyNumLen = String.valueOf(luckyNum).length() / 2;
        int numDivider = 1;
        while (halfLuckyNumLen > 0) {
            numDivider *= 10;
            halfLuckyNumLen--;
        }
        int leftSideNum = luckyNum / numDivider;
        int outputLeftNum = leftSideNum;
        int rightSideNum = luckyNum % numDivider;
        int outputRightNum = rightSideNum;
        int leftSum = 0;
        int rightSum = 0;
        while (numDivider > 0) {
            int leftRemainder = leftSideNum % 10;
            leftSum += leftRemainder;
            leftSideNum /= 10;
            int rightRemainder = rightSideNum % 10;
            rightSum += rightRemainder;
            rightSideNum /= 10;
            numDivider--;
        }
        int outputLen = String.valueOf(luckyNum).length() / 2;
        String lucky = (leftSum == rightSum) ? "Счастливое число" : "Несчастливое число";
        String addZero = (outputLen != String.valueOf(outputRightNum).length()) ? "00" : "";
        System.out.printf("""
                %d - %s
                Сумма цифр: %d = %d
                Сумма цифр: %s%d = %d
                """, luckyNum, lucky, outputLeftNum, leftSum, addZero, outputRightNum, rightSum);

        System.out.println("\n8 ПРОСТОЙ ГЕНЕРАТОР ПАРОЛЯ");
        StringBuilder password = new StringBuilder();
        Random rnd = new Random();
        int passwordLength = password.length();
        String passwordStrength = "";
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        while (passwordLength < rnd.nextInt(5, 15)) {
            char charTmp = (char) rnd.nextInt(33, 122);
            if (Character.isUpperCase(charTmp)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(charTmp)) {
                hasLowerCase = true;
            } else if (Character.isDigit(charTmp)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(charTmp)) {
                hasSpecialChar = true;
            }
            password.append(charTmp);
            passwordLength++;
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