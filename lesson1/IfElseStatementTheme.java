import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1 Перевод псевдокода на язык JAVA");

        boolean isMale = true;
        if (!isMale) {
            System.out.println("Мужской пол.");
        } else {
            System.out.println("Женский пол.");
        }
        int age = 15;
        if (age > 18) {
            System.out.println("Доступ открыт.");
        } else {
            System.out.println("Доступ запрещен, ваш возраст меньше 18.");
        }
        double height = 1.6;
        if (height < 1.8) {
            System.out.println("Ваш рост ниже 1.8 метра.");
        } else {
            System.out.println("Ваш рост выше 1.8 метра.");
        }

        System.out.println("\n2 ПОИСК БОЛЬШЕГО ЧИСЛА ШАГОВ");
        int todaySteps = 500;
        int yesterdaySteps = 3500;
        double everageSteps = (todaySteps + yesterdaySteps) / 2; 

        if (todaySteps > yesterdaySteps) {
            System.out.println("Сегодня шагов больше чем вчера " + todaySteps);
        } else if (todaySteps < yesterdaySteps) {
            System.out.println("Вчера шагов больше чем сегодня " + yesterdaySteps);
        } else {
            System.out.println("Количество шагов одинаково.");
        }
        System.out.printf("""
                Шаги сегодня: %d
                Шаги вчера: %d
                Среднее количество шагов: %.1f
                """, todaySteps, yesterdaySteps, everageSteps);

        System.out.println("\n3 ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ");
        int guestNumber = 10;
        if (guestNumber >= 0) {
            if (guestNumber == 0) {
                System.out.println("Пока никто не записался на мероприятие!");
            } else if (guestNumber % 2 == 0) {
                System.out.println("Записалось " + guestNumber +
                        " гостей. Можно формировать пары для конкурсов.");
            } else {
                System.out.println("Записалось " + guestNumber + " гостей. Нужны индивидуальные задания.");
            } 
        } else {
            System.out.println("Число гостей не может быть меньше нуля!");
        }

        System.out.println("\n4 ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА");
        System.out.println("Первый вариант: с помощью проверки символа на его вхождение в диапазон кодов");
        String name = "2Maria";
        char firstChar = name.charAt(0); 
        String outputMessage = "";

        if (firstChar >= 'a' && firstChar <= 'z') {
            outputMessage = " начинается с маленькой буквы - ";
        } else if (firstChar >= 'A' && firstChar <= 'Z') {
            outputMessage = " начинается с большой буквы - ";
        } else if (firstChar >= '0' && firstChar <= '9') {
            outputMessage = " начинается с цифры - ";
        } else if (firstChar >= '!' && firstChar <= '/') {
            outputMessage = " начинается с символа - ";
        }
        System.out.println("Имя: " + name + outputMessage + firstChar);

        System.out.println("\nВторой вариант: с помощью методов класса Character, определяющих символы");
        if (Character.isLowerCase(firstChar)) {
            outputMessage = " начинается с маленькой буквы - ";
        } else if (Character.isUpperCase(firstChar)) {
            outputMessage = " начинается с большой буквы - ";
        } else if (Character.isDigit(firstChar)) {
            outputMessage = " начинается с цифры - ";
        } else {
            outputMessage = " начинается с символа - ";
        }
        System.out.println("Имя: " + name + outputMessage + firstChar);

        System.out.println("\n5 ИНВЕНТАРИЗАЦИЯ");
        int serialNumber = 234;
        int itemNumber = 134;
        boolean lastDigit = (serialNumber % 10 == itemNumber % 10);
        boolean middleDigit = (serialNumber / 10 % 10 == itemNumber / 10 % 10);
        boolean firstDigit = (serialNumber / 100 % 10 == itemNumber / 100 % 10);

        if (lastDigit && middleDigit && firstDigit) {
            System.out.println("[№" + itemNumber + "]: " + "компьютер на 3-м этаже в кабинете 2");
        } else {
            if (!lastDigit && !middleDigit && !firstDigit) {
                System.out.println("[№" + itemNumber + "]: " + "оборудование не идентифицировано");
            } else {
                System.out.printf("""
                        Нет полного совпадения:
                        База данных: [№%d]
                        Фактический: [№_%d]
                        """, serialNumber, itemNumber % 100);
            }
        }

        System.out.println("\n6 ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        System.out.println("Первый вариант");
        float depositAmount = 300_000f;
        float interesOnDeposit = 0.0f;
        if (depositAmount < 100_000.000f) {
            interesOnDeposit = 0.05f;
        } else if (depositAmount > 100_000 & depositAmount < 300_000) {
            interesOnDeposit = 0.07f;
        } else if (depositAmount >= 300_000) {
            interesOnDeposit = 0.1f;
        }
        System.out.println("Сумма вклада: " + depositAmount + "\n" +
                "Сумма начисленного %: " + depositAmount * interesOnDeposit + "\n" +
                "Итоговая сумма с %: " + (depositAmount + interesOnDeposit));

        System.out.println("\nВторой вариант");
        var depositAmountBd = BigDecimal.valueOf(150220_000);
        var interesOnDepositBd = BigDecimal.ZERO;
        if (depositAmountBd.compareTo(BigDecimal.valueOf(100000)) < 0) {
            interesOnDepositBd = depositAmountBd.multiply(new BigDecimal("0.05"));
        } else if (depositAmountBd.compareTo(BigDecimal.valueOf(100000)) > 0 &
                depositAmountBd.compareTo(BigDecimal.valueOf(300000)) < 0) {
            interesOnDepositBd = depositAmountBd.multiply(new BigDecimal("0.07"));
        } else if (depositAmountBd.compareTo((BigDecimal.valueOf(300000))) > 0) {
            interesOnDepositBd = depositAmountBd.multiply(new BigDecimal("0.1"));
        }
        System.out.println("Сумма вклада: " + depositAmountBd + "\n" +
                "Сумма начисленного %: " + interesOnDepositBd + "\n" +
                "Итоговая сумма с %: " + depositAmountBd.add(interesOnDepositBd));

        System.out.println("\n7 ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ");
        float historyPersent = 61.0f;
        int historyGrade = 2;

        if (historyPersent > 60 & historyPersent < 73) {
            historyGrade = 3;
        } else if (historyPersent > 73 & historyPersent < 91) {
            historyGrade = 4;
        } else if (historyPersent > 91) {
            historyGrade = 5;
        }

        float programmingPersent = 61.0f;
        int programmingGrade = 2;

        if (programmingPersent > 60 & programmingPersent < 73) {
            programmingGrade = 3;
        } else if (programmingPersent > 73 & programmingPersent < 91) {
            programmingGrade = 4;
        } else if (programmingPersent > 91) {
            programmingGrade = 5;
        }

        float averageGrade = (historyGrade + (float) programmingGrade) / 2; 
        float persent = (historyPersent + programmingPersent) / 2;
        System.out.printf("""
                История: %.1f %%
                Программирование: %.1f %%
                Cредний балл оценок по предметам: %.1f %%
                Cредний %% по предметам: %.1f %%
                """, historyPersent, programmingPersent, averageGrade, persent);

        System.out.println("\n8 РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ");
        var soldOneMonth = new BigDecimal("1025.233");
        var oneMonthRentCost = new BigDecimal("5123.018");
        var oneMonthProductionCost = new BigDecimal("9001.729");
        var period = BigDecimal.valueOf(12);
        var oneYearProfit = soldOneMonth.multiply(period).subtract(oneMonthRentCost.multiply(period))
                .subtract(oneMonthProductionCost.multiply(period));
        var symbol = (oneYearProfit.compareTo(BigDecimal.valueOf(0)) > 0)
                ? "Прибыль за год: +" : "Прибыль за год:";
        System.out.println(symbol + oneYearProfit);
    }
}
