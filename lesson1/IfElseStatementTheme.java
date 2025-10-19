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
        int stepsToday = 2500;
        int stepsYesterday = 2500;
        double everageSteps = (stepsToday + stepsYesterday) / 2; 
        if (stepsToday > stepsYesterday) {
            System.out.printf("""
                    Сегодня больше шагов: %d
                    Среднее количество шагов: %.1f
                    """, stepsToday, everageSteps);
        } else if (stepsToday < stepsYesterday) {
            System.out.printf("""
                    Вчера больше шагов: %d
                    Среднее количество шагов: %.1f
                    """, stepsYesterday, everageSteps);
        } else {
            System.out.printf("""
                    Количество шагов равно:
                    Среднее количество шагов: %.1f
                    """, everageSteps);
        }

        System.out.println("\n3 ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ");
        int guestNumber = 5;
        if (guestNumber >= 0) {
            if (guestNumber == 0) {
                System.out.println("Пока никто не записался на мероприятие!");
            } else if (guestNumber % 2 == 0) {
                System.out.println("Записалось 10 гостей. Можно формировать пары для конкурсов.");
            } else {
                System.out.println("Записалось 11 гостей. Нужны индивидуальные задания.");
            } 
        } else {
            System.out.println("отрицательное: число не должно быть меньше нуля");
        }

        System.out.println("\n4 ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА");
        System.out.println("Первый вариант: с помощью проверки символа на его вхождение в диапазон кодов");
        String name = "YMaria";

        if (name.charAt(0) >= 'a' && name.charAt(0) <= 'z') {
            System.out.println("Имя: " + name + " начинается с маленькой буквы - " + name.charAt(0));
        }
        if (name.charAt(0) >= 'A' && name.charAt(0) <= 'Z') {
            System.out.println("Имя: " + name + " начинается с большой буквы - " + name.charAt(0));
        }
        if (name.charAt(0) >= '0' && name.charAt(0) <= '9') {
            System.out.println("Имя: " + name + " начинается с цифры - " + name.charAt(0));
        }
        if (name.charAt(0) >= '!' && name.charAt(0) <= '/') {
            System.out.println("Имя: " + name + " начинается с символа - " + name.charAt(0));
        }

        System.out.println("\nВторой вариант: с помощью методов класса Character, определяющих символы");
        if (Character.isLowerCase(name.charAt(0))) {
            System.out.println("Имя: " + name + " начинается с маленькой буквы - " + name.charAt(0));
        } else if (Character.isUpperCase(name.charAt(0))) {
            System.out.println("Имя: " + name + " начинается с большой буквы - " + name.charAt(0));
        } else if (Character.isDigit(name.charAt(0))) {
            System.out.println("Имя: " + name + " начинается с цифры - " + name.charAt(0));     
        } else {
            System.out.println("Имя: " + name + " начинается с символа - " + name.charAt(0));
        }

        System.out.println("\n5 ИНВЕНТАРИЗАЦИЯ");
        int serialNumber = 234;
        int itemNumber = 234;
        boolean flag = false;

        if (flag = (serialNumber % 10 == itemNumber % 10 &&
                serialNumber / 10 % 10 == itemNumber / 10 % 10 &&
                serialNumber / 100 % 10 == itemNumber / 100 % 10) ? true : false) {
            System.out.println("[№" + itemNumber + "]: " + "компьютер на 3-м этаже в кабинете 2");
        } else if (flag = (serialNumber % 10 == itemNumber % 10 &&
                        serialNumber / 10 % 10 == itemNumber / 10 % 10) ? true : false) {
            System.out.printf("""
                    Нет полного совпадения:
                    База данных: [№%d]
                    Фактический: [№_%d]
                    """, serialNumber, itemNumber % 100);
        } else if (flag = (serialNumber % 10 == itemNumber % 10) ? true : false) {
            System.out.printf("""
                    Нет полного совпадения:
                    База данных: [№%d]
                    Фактический: [№_%d]
                    """, serialNumber, itemNumber % 10);
        } else {
            System.out.println("[№" + itemNumber + "]: " + "оборудование не идентифицировано");
        }

        System.out.println("\n6 ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        System.out.println("Первый вариант");
        float depositAmount = 300_000.79f;
        float interesOnDeposit = 0.0f;
        if (depositAmount < 100_000.000f) {
            interesOnDeposit = depositAmount * 0.05f;
        } else if (depositAmount > 100_000 & depositAmount < 300_000) {
            interesOnDeposit = depositAmount * 0.07f;
        } else if (depositAmount > 300_000) {
            interesOnDeposit = depositAmount * 0.1f;
        }
        System.out.println("Сумма вклада: " + depositAmount + "\n" +
                "Сумма начисленного %: " + interesOnDeposit + "\n" +
                "Итоговая сумма с %: " + (depositAmount + interesOnDeposit));

        System.out.println("\nВторой вариант");
        var depositAmountBd = BigDecimal.valueOf(150220_000);
        var interesOnDepositBd = BigDecimal.valueOf(0);
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
        float history = 59.0f;
        int historyGrade = 0;

        if (history <= 60) {
            historyGrade = 2;
        } else if (history > 60 & history < 73) {
            historyGrade = 3;
        } else if (history > 73 & history < 91) {
            historyGrade = 4;
        } else if (history > 91) {
            historyGrade = 5;
        }

        float programming = 61.0f;
        int programmingGrade = 0;

        if (programming <= 60) {
            programmingGrade = 2;
        } else if (programming > 60 & programming < 73) {
            programmingGrade = 3;
        } else if (programming > 73 & programming < 91) {
            programmingGrade = 4;
        } else if (programming > 91) {
            programmingGrade = 5;
        }

        float averageGrade = ((float) historyGrade + (float) programmingGrade) / 2; 
        float persent = (history + programming) / 2;
        System.out.printf("""
            История: %.1f %%
            Программирование: %.1f %%
            Cредний балл оценок по предметам: %.1f %%
            Cредний %% по предметам: %.1f %%
                """, history, programming, averageGrade, persent);

        System.out.println("\n8 РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ");
        var soldOneMonth = new BigDecimal("13025.233");
        var rentCost = new BigDecimal("5123.018");
        var productionCost = new BigDecimal("9001.729");
        var period = BigDecimal.valueOf(12);
        var oneYearProfit = soldOneMonth.multiply(period);
        var oneYearRentCost = rentCost.multiply(period);
        var oneYearProductionCost = productionCost.multiply(period);
        oneYearProfit = oneYearProfit.subtract(oneYearRentCost).subtract(oneYearProductionCost);
        if (oneYearProfit.compareTo(new BigDecimal("0")) > 0) {
            System.out.printf("""
                    Прибыль за год: +%.2f
                    """, oneYearProfit);
        } else {
            System.out.printf("""
                    Прибыль за год: %.2f
                    """, oneYearProfit);
        }
    }
}
