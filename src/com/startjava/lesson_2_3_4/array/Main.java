package com.startjava.lesson_2_3_4.array;

public class Main {
    private static final int LENGTH = 15;

    public static void main(String[] args) {
        reverseBankTransactions();
        calculateFactorial();
        deleteElementByIndex();
        fillSortedChars();
        fillSortedUniqueNumbers();
        checkPasswordStrength();
        imitateTypewriter();
    }

    private static void reverseBankTransactions() {
        int[][] inputTransactions = {
                {},
                null,
                {5},
                {6, 8, 9, 1},
                {13, 8, 5, 3, 2, 1, 1}
        };
        for (int[] transactions : inputTransactions) {
            int[] reversed = Arrays.reverse(transactions);
            Console.print("Исходные транзакции:", transactions);
            Console.print("В обратном порядке:", reversed);
        }
    }

    private static void calculateFactorial() {
        int[][] factorialOrigins = {
                {0},
                null,
                {-5},
                {21, 0, 7},
                {1, 20, 5, -3}
        };
        for (int[] origin : factorialOrigins) {
            long[] factorialResult = Arrays.calculateFactorial(origin);
            Console.printFactorialsExpressions(factorialResult, origin);
        }
    }

    private static void deleteElementByIndex() {
        float[] originRandom = Arrays.fillRandomArray(LENGTH);
        float[] changed = Arrays.removeBiggerElement(originRandom, -1);
        Console.printArray(originRandom, changed, -1);
        originRandom = Arrays.fillRandomArray(LENGTH);
        changed = Arrays.removeBiggerElement(originRandom, 15);
        Console.printArray(originRandom, changed, 15);
        originRandom = Arrays.fillRandomArray(LENGTH);
        changed = Arrays.removeBiggerElement(originRandom, 0);
        Console.printArray(originRandom, changed, 0);
        originRandom = Arrays.fillRandomArray(LENGTH);
        changed = Arrays.removeBiggerElement(originRandom, 14);
        Console.printArray(originRandom, changed, 14);
    }

    private static void fillSortedChars() {
        char[][] sortedChars = {
                Arrays.fillArraySortedChars('0', '9', true),
                Arrays.fillArraySortedChars('/', '!', false),
                Arrays.fillArraySortedChars('A', 'Z', false)
        };
        for (char[] array : sortedChars) {
            Console.printTriangle(array);
        }
    }

    private static void checkPasswordStrength() {
        char[][] password = {
                {'1', '2', '3', '4', '5', '6'},
                Arrays.generateCharArrayInRange(),
                Arrays.generateCharArrayInRange(),
                Arrays.generateCharArrayInRange()
        };
        for (int i = 0; i < password.length; i++) {
            boolean isChecked = Arrays.checkPassword(password[i]);
            Console.printValidateResult("x Strong Password: - ",
                    "✓ Password cracked: - ", isChecked, password[i]);
        }
    }

    private static void fillSortedUniqueNumbers() {
        int[] uniqueNumbers = Arrays.fillSortedUniqueNumbersArray(-50, -10, 23);
        Console.printInLimitNumbersRange(uniqueNumbers, 23);
        uniqueNumbers = Arrays.fillSortedUniqueNumbersArray(10, 50, 10);
        Console.printInLimitNumbersRange(uniqueNumbers, 10);
        uniqueNumbers = Arrays.fillSortedUniqueNumbersArray(-34, -34, 1);
        Console.printInLimitNumbersRange(uniqueNumbers, 1);
        uniqueNumbers = Arrays.fillSortedUniqueNumbersArray(-1, 2, -3);
        Console.printInLimitNumbersRange(uniqueNumbers, -3);
        uniqueNumbers = Arrays.fillSortedUniqueNumbersArray(5, -8, 2);
        Console.printInLimitNumbersRange(uniqueNumbers, 2);
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
}
