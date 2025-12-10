public class Main {
    public static void main(String[] args) {
        nonBm();
        System.out.println();
        bm();
    }
    
    public static void nonBm() {
        NonBooleanMethods nonBm = new NonBooleanMethods();
        System.out.println("HЕ BOOLEAN-МЕТОДЫ");
        nonBm.findLongestWord();
        nonBm.selectMenuItem();
        nonBm.calculateEverageGrade();
        nonBm.countUniqueWords();
        nonBm.printErrorMessage();
        nonBm.synchronizeDataCloudStorage();
        nonBm.restoreBackupData();
        nonBm.pauseDownloadFile();
        nonBm.resetToFactoryDefaults();
        nonBm.writeToExternalStorage();
        nonBm.celsiusToFahrenheit();
        nonBm.printMathExpression();
        nonBm.findGameWinner();
        nonBm.findBookByAuthor();
    }

    public static void bm() {
        BooleanMethods bm = new BooleanMethods();
        System.out.println("BOOLEAN-МЕТОДЫ");
        System.out.println(bm.isFinish());
        System.out.println(bm.hasUniqueDigit());
        System.out.println(bm.isLetterEntered());
        System.out.println(bm.hasEqualNumbers());
        System.out.println(bm.isAttemptsMarioGame());
        System.out.println(bm.isEmptyStringEntered());
        System.out.println(bm.isEvenNumber());
        System.out.println(bm.isValidSsdPath());
        System.out.println(bm.isExistingFile());
    }
}