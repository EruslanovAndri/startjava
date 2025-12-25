package com.startjava.lesson_2_3_4.method.naming;

public class Main {
    public static void main(String[] args) {
        runNonBm();
        System.out.println();
        runBm();
    }
    
    private static void runNonBm() {
        System.out.println("HЕ BOOLEAN-МЕТОДЫ");
        NonBooleanMethods nonBm = new NonBooleanMethods();
        nonBm.findLongestWord();
        nonBm.selectMenuItem();
        nonBm.calculateEverageGrade();
        nonBm.countUniqueWords();
        nonBm.printErrorMessage();
        nonBm.syncCloudStorage();
        nonBm.restoreBackup();
        nonBm.pauseDownload();
        nonBm.resetToFactoryDefaults();
        nonBm.writeToFile();
        nonBm.celsiusToFahrenheit();
        nonBm.printMathExpression();
        nonBm.findGameWinner();
        nonBm.findBookByAuthor();
    }

    private static void runBm() {
        System.out.println("BOOLEAN-МЕТОДЫ");
        BooleanMethods bm = new BooleanMethods();
        System.out.println(bm.isFinish());
        System.out.println(bm.hasUniqueDigit());
        System.out.println(bm.isLetter());
        System.out.println(bm.hasEqualNumbers());
        System.out.println(bm.hasAttempt());
        System.out.println(bm.isBlank());
        System.out.println(bm.isEvenNumber());
        System.out.println(bm.isValidPath());
        System.out.println(bm.isExistingFile());
    }
}