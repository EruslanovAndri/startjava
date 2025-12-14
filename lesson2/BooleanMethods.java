public class BooleanMethods {
    public boolean isFinish() {
        System.out.print(Methods.getMethodName() +
                "() -> программа выполняется далее или завершается? ");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.print(Methods.getMethodName() +
                "() -> последовательность содержит уникальную цифру? ");
        return false;
    }

    public boolean isLetter() {
        System.out.print(Methods.getMethodName() +
                "() -> пользователь ввел букву или что-то другое? ");
        return false;
    }

    public boolean hasEqualNumbers() {
        System.out.print(Methods.getMethodName() +
                "() -> в проверяемых числах, есть равные цифры? ");
        return false;
    }

    public boolean hasAttempt() {
        System.out.print(Methods.getMethodName() +
                "() -> в игре 'Марио' остались попытки? ");
        return false;
    }

    public boolean isBlank() {
        System.out.print(Methods.getMethodName() +
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }

    public boolean isEvenNumber() {
        System.out.print(Methods.getMethodName() +
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return false;
    }

    public boolean isValidPath() {
        System.out.print(Methods.getMethodName() +
                "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return false;
    }

    public boolean isExistingFile() {
        System.out.print(Methods.getMethodName() +
                "() -> файл по указанному адресу существует? ");
        return false;
    }
}

