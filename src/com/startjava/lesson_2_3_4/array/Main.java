package com.startjava.lesson_2_3_4.array;

public class Main {
    private static final int LENGTH = 15;

    public static void main(String[] args) {
        reverseBankTransactions();

        calculateFactorial();

        deleteElementByIndex(LENGTH, -1);
        deleteElementByIndex(LENGTH, 15);
        deleteElementByIndex(LENGTH, 0);
        deleteElementByIndex(LENGTH, 14);

        fillSortedChars('0', '9', true);
        fillSortedChars('/', '!', false);
        fillSortedChars('A', 'Z', false);

        fillSortedUniqueNumbers(-50, -10, 23);
        fillSortedUniqueNumbers(10, 50, 10);
        fillSortedUniqueNumbers(-34, -34, 1);
        fillSortedUniqueNumbers(-1, 2, -3);
        fillSortedUniqueNumbers(5, -8, 2);

        checkPasswordStrength();

        imitateTypewriter();
    }

    private static void calculateFactorial() {
        int[][] factorialOrigins;
        factorialOrigins = new int[][]{{0}, null, {-5}, {21, 0, 7}, {1, 20, 5, -3}};
        for (int[] origin : factorialOrigins) {
            long[] factorialResult = Arrays.calculateFactorial(origin);
            Console.printFactorialsExpressions(factorialResult, origin);
        }
    }

    private static void checkPasswordStrength() {
        char[][] password = {{'1', '2', '3', '4', '5', '6'}, Arrays.generateCharArrayInRange(),
                Arrays.generateCharArrayInRange(), Arrays.generateCharArrayInRange()};
        for (int i = 0; i < password.length; i++) {
            boolean isChecked = Arrays.checkPassword(password[i]);
            Console.printValidateResult("x Strong Password: - ",
                    "✓ Password cracked: - ", isChecked, password[i]);
        }
    }

    private static void deleteElementByIndex(int length, int index) {
        float[] inputRandom = Arrays.fillRandomArray(length);
        float[] clean = Arrays.removeBiggerElement(inputRandom, index);
        Console.printArray(inputRandom, clean, index);
    }

    private static void fillSortedChars(char leftSide, char rightSide, boolean direction) {
        char[] sortedChars = Arrays.fillArraySortedChars(leftSide, rightSide, direction);
        Console.printTriangle(sortedChars);
    }

    private static void fillSortedUniqueNumbers(int start, int end, int limitNumbers) {
        int[] unique = Arrays.fillSortedUniqueNumbersArray(start, end, limitNumbers);
        Console.printInLimitNumbersRange(unique, limitNumbers);
    }

    private static void imitateTypewriter() {
        String[] texts = {
                "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n" +
                        "- James Gosling",
                "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n" +
                        "- Robert Martin",
                null, ""};
        for (String text : texts) {
            int[] shortAndLongWord = Arrays.findShortestLongestWordIndex(text);
            StringBuilder convertToUpperCase = Arrays.convertToUpperCase(shortAndLongWord, text);
            Console.imitateTypewriter(convertToUpperCase);
        }
    }

    private static void reverseBankTransactions() {
        int[][] inputTransactions = {{}, null, {5}, {6, 8, 9, 1}, {13, 8, 5, 3, 2, 1, 1}};
        for (int[] transaction : inputTransactions) {
            int[] reversed = Arrays.reverse(transaction);
            Console.print("Исходные транзакции:", transaction,
                    "В обратном порядке:", reversed);
        }
    }
}
