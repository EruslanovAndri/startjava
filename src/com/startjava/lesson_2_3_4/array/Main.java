package com.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) {
        char[][] sortedChars = {Arrays.fillArraySortedChars('0', '9', true),
                Arrays.fillArraySortedChars('/', '!', false),
                Arrays.fillArraySortedChars('A', 'Z', false)};
        for (char[] chars : sortedChars) {
            Console.printTriangle(chars);
        }

        System.out.println();
        int[][] origins = {{}, null, {5}, {6, 8, 9, 1}, {13, 8, 5, 3, 2, 1, 1}};
        for (int[] origin : origins) {
            int[] reversedTransaction = Arrays.reverse(origin);
            Console.printTransactions(origin, reversedTransaction);
        }

        System.out.println();
        float[] originArray = Arrays.fillRandomArray();
        float[] changedArray = Arrays.remove(originArray, -1);
        Console.printArray(originArray, changedArray, -1);
        originArray = Arrays.fillRandomArray();
        changedArray = Arrays.remove(originArray, 15);
        Console.printArray(originArray, changedArray, 15);
        originArray = Arrays.fillRandomArray();
        changedArray = Arrays.remove(originArray, 0);
        Console.printArray(originArray, changedArray, 0);
        originArray = Arrays.fillRandomArray();
        changedArray = Arrays.remove(originArray, 14);
        Console.printArray(originArray, changedArray, 14);

        System.out.println();
        int[][] factorialOrigins;
        factorialOrigins = new int[][]{{0}, null, {-5}, {21, 0, 7}, {1, 20, 5, -3}};
        for (int[] origin : factorialOrigins) {
            long[] factorialResult = Arrays.calculateFactorial(origin);
            Console.printFactorialsExpressions(factorialResult, origin);
        }

        System.out.println();
        char[][] password = {{'1', '2', '3', '4', '5', '6'}, Arrays.generatePassword(),
                Arrays.generatePassword(), Arrays.generatePassword()};
        for (int i = 0; i < password.length; i++) {
            boolean isChecked = Arrays.checkPassword(password[i]);
            Console.printValidateResult(isChecked, password[i]);
        }

        System.out.println();
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

        System.out.println();
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
}
