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
            Console.print(" В обратном порядке:", reversed);
        }
        Console.printEmptyString();
    }

    private static void calculateFactorial() {
        int[][] inputNumbers = {
                {0},
                null,
                {-5},
                {21, 0, 7},
                {1, 20, 5, -3}
        };
        for (int[] numbers : inputNumbers) {
            long[] factorialResult = Arrays.calculateFactorial(numbers);
            Console.printFactorialsExpressions(factorialResult, numbers);
        }
        Console.printEmptyString();
    }

    private static void deleteElementByIndex() {
        int[] indexes = {-1, 15, 0, 14};
        for (int index : indexes) {
            float[] originRandom = Arrays.makeRandomArray(LENGTH);
            float[] changed = Arrays.zeroOutElementsBeyond(originRandom, index);
            Console.printArray("\nИсходный массив:", originRandom,
                    "\n Значение из ячейки по переданному индексу = ", index);
            Console.printArray("\nИзмененный массив:", changed,
                    "\n Значение из ячейки по переданному индексу = ", index);
        }
        Console.printEmptyString();
    }

    private static void fillSortedChars() {
        char[][] sortedChars = {
                Arrays.makeArraySortedChars('0', '9', true),
                Arrays.makeArraySortedChars('/', '!', false),
                Arrays.makeArraySortedChars('A', 'J', false)
        };
        for (char[] array : sortedChars) {
            Console.printTriangle(array);
        }
    }

    private static void fillSortedUniqueNumbers() {
        int[] uniqueNumbers = Arrays.fillSortedUniqueNumbersArray(-30, -10, 23);
        Console.printInLimitNumbersRange(uniqueNumbers, 23);
        uniqueNumbers = Arrays.fillSortedUniqueNumbersArray(10, 50, 10);
        Console.printInLimitNumbersRange(uniqueNumbers, 10);
        uniqueNumbers = Arrays.fillSortedUniqueNumbersArray(-34, -34, 1);
        Console.printInLimitNumbersRange(uniqueNumbers, 1);
        uniqueNumbers = Arrays.fillSortedUniqueNumbersArray(-1, 2, -3);
        Console.printInLimitNumbersRange(uniqueNumbers, -3);
        uniqueNumbers = Arrays.fillSortedUniqueNumbersArray(5, -8, 2);
        Console.printInLimitNumbersRange(uniqueNumbers, 2);
        Console.printEmptyString();
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
        Console.printEmptyString();
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
            StringBuilder convertToUpperCase = Arrays.convertToUpperCaseInRange(shortAndLongWord, text);
            Console.imitateTypewriter(convertToUpperCase);
        }
    }
}
