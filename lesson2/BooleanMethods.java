public class BooleanMethods {
    public boolean isFinish() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> программа выполняется далее или завершается?");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> последовательность содержит уникальную цифру?");
        return false;
    }

    public boolean isLetterEntered() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> пользователь ввел букву или что-то другое?");
        return false;
    }

    public boolean hasEqualNumbers() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> в проверяемых числах, есть равные цифры?");
        return false;
    }

    public boolean isAttemptsMarioGame() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> в игре 'Марио' остались попытки?");
        return false;
    }

    public boolean isEmptyStringEntered() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> пользователь ввёл пустую строку или из одних пробелов?");
        return false;
    }

    public boolean isEvenNumber() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> на кубике, который бросил компьютер, выпало четное число?");
        return false;
    }

    public boolean isValidSsdPath() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> путь до файла, который вы ищите на ssd, действительный?");
        return false;
    }

    public boolean isFileExist() {
        System.out.print(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "() -> файл по указанному адресу существует?");
        return false;
    }
}

