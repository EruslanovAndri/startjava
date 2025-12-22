package com.startjava.lesson_1.base;

import java.util.Random;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1 ВЫВОД ASCII-СИМВОЛОВ");
        System.out.printf("%s %s %s %n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int i = 33; i <= 47; i++) {
            if (i % 2 != 0) {
                System.out.printf("%-1s %-9d %-10c %s %n", "", i, i, Character.getName(i));
            } 
        }
        for (int i = 97; i <= 122; i++) {
            if (i % 2 == 0) {
                System.out.printf("%-1s %-9d %-10c %s %n", "", i, i, Character.getName(i));
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
            System.out.println(str1);
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
        int leftHalfNum = luckyNum / 1000;
        int rightHalfNum = luckyNum % 1000;
        int leftHalfSum = 0;
        int rightHalfSum = 0;

        while (leftHalfNum > 0) {
            int remainder = rightHalfNum % 10;
            rightHalfSum += remainder;
            rightHalfNum /= 10;
            remainder = leftHalfNum % 10;
            leftHalfSum += remainder;
            leftHalfNum /= 10;
        }
        String lucky = (leftHalfSum == rightHalfSum) ? "Счастливое число" : "Несчастливое число";
        System.out.printf("""
                %d - %s
                Сумма цифр: %d = %d
                Сумма цифр: %03d = %d
                """, luckyNum, lucky, luckyNum / 1000, leftHalfSum, luckyNum % 1000, rightHalfSum);

        System.out.println("\n8 ПРОСТОЙ ГЕНЕРАТОР ПАРОЛЯ");
        StringBuilder password = new StringBuilder();
        Random rnd = new Random();
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        while (password.length() < 8) {
            char ch = (char) rnd.nextInt(33, 122);
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
            password.append(ch);
        }
        String passwordStrength;
        if (password.length() >= 8 && hasUpperCase && hasLowerCase && hasSpecialChar && !hasDigit) {
            passwordStrength = "Надежный";
        } else if (password.length() >= 8 && hasUpperCase && hasDigit && !hasLowerCase && !hasSpecialChar) {
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