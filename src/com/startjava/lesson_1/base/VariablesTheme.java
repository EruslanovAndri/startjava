package com.startjava.lesson_1.base;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VariablesTheme {
    public static void main(String[] args) {
        final LocalTime startTime = LocalTime.now();
        final long start = System.nanoTime();

        System.out.println("1 ВЫВОД ASCII-ГРАФИКИ \n");
        System.out.println("первый (с помощью конкатенации)");
        System.out.println(
                "                          /\\" +
                "\n    j    a    v     v    /  \\" +
                "\n    j   a a    v   v    /_( )\\" +
                "\nj   j  aaaaa    V V    /      \\" +
                "\n j j  a     a    V    /___/\\___\\\n");
        System.out.println("второй (с помощью текстового блока)");
        String block = 
                """
                                        /\\
                    j    a   v     v   /  \\
                    j   a a   v   v   /_( )\\
                j   j  aaaaa   V V   /      \\
                 j j  a     a   V   /___/\\___\\
                """.indent(4);
        System.out.println(block);

        System.out.println("\n2 РАСЧЕТ СТОИМОСТИ ТОВАРА \n");
        System.out.println("Первый вариант решения.");
        float penPrice = 105.5f; 
        float bookPrice = 235.23f;
        int discount = 11;
        float basePrice = penPrice + bookPrice;
        float discountSum = (basePrice / 100) * discount;
        float discountPrice = basePrice - discountSum;
        System.out.println("Общая стоимость товара = " + basePrice);
        System.out.println("Сумма скидки = " + discountSum);
        System.out.println("Стоимость товара со скидкой = " + discountPrice + "\n");

        System.out.println("Второй вариант решения.");
        var penPriceBd = new BigDecimal("105.5");
        var bookPriceBd = new BigDecimal("235.23");
        var discountBd = BigDecimal.valueOf(11);
        var basePriceBd = penPriceBd.add(bookPriceBd);
        var discountSumBd = basePriceBd.divide(BigDecimal.valueOf(100), 2,
                RoundingMode.HALF_UP).multiply(discountBd);
        var discountedPriceBd = basePriceBd.subtract(discountSumBd);
        System.out.println("Общая стоимость товара = " + basePriceBd);
        System.out.println("Сумма скидки = " + discountSum);
        System.out.println("Стоимость товара со скидкой = " + discountedPriceBd + "\n");

        System.out.println("3 ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ\n");
        System.out.println("С помощью третьей переменной");
        int a = 2;
        int b = 5;
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("Результат: A = " + a + " B = " + b);
        System.out.println("С помощью арифметических операций");
        b -= a;
        a += b; 
        b = a - b;
        System.out.println("Результат: A = " + a + " B = " + b);
        System.out.println("С помощью побитовых операций");
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("Результат: A = " + a + " B = " + b);

        System.out.println("\n4 ДЕКОДИРОВАНИЕ СООБЩЕНИЯ \n");
        int codeAsciiOne = 1055;
        int codeAsciiTwo = 1088;
        int codeAsciiThree = 1080;
        int codeAsciiFour = 1074;
        int codeAsciiFive = 1077;
        int codeAsciiSix = 1090;
        System.out.printf("%d %d %d %d %d %d",
                codeAsciiOne, codeAsciiTwo, codeAsciiThree,
                codeAsciiFour, codeAsciiFive, codeAsciiSix);
        System.out.printf("\n%4c %4c %4c %4c %4c %4c %n",
                codeAsciiOne, codeAsciiTwo,
                codeAsciiThree, codeAsciiFour,
                codeAsciiFive, codeAsciiSix, "\n");

        System.out.println("\n5 АНАЛИЗ КОДА ТОВАРА \n");
        int productCode = 123;
        int productCategory = productCode / 100 % 10;
        int subcategoryCode = productCode / 10 % 10;
        int packageType = productCode % 10;
        int checksum = productCategory + subcategoryCode + packageType;
        int verificationCode = productCategory * subcategoryCode * packageType;
        System.out.printf("""
                Код товара: %d
                    категория товара - %d
                    подкатегория - %d
                    упаковка - %d
                Контрольная сумма: %d
                Проверочный код: %d
                """, productCode, productCategory, subcategoryCode,
                        packageType, checksum, verificationCode);

        System.out.println("\n6 ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ \n");
        byte temperature = Byte.MAX_VALUE;
        System.out.printf("""
                [Температура: С ]
                    Исходное: %d
                    +1: %d
                    -1: %d%n
                """, temperature, ++temperature, --temperature);

        short pressure = Short.MAX_VALUE;
        System.out.printf("""
                [Давление: PA]
                    Исходное: %d
                    +1: %d
                    -1: %d%n
                """, pressure, ++pressure, --pressure);

        char codeSystemStatus = Character.MAX_VALUE;
        System.out.printf("""
                [Код состояния системы]
                    Исходное: %d
                    +1: %d
                    -1: %d%n
                """, (int) codeSystemStatus, (int) ++codeSystemStatus, (int) --codeSystemStatus);

        int traveledDistance = Integer.MAX_VALUE;
        System.out.printf("""
                [Пройденное расстояние км:]
                    Исходное: %d
                    +1: %d
                    -1: %d%n
                """, traveledDistance, ++traveledDistance, --traveledDistance);

        long sinceLaunchTime = Long.MAX_VALUE;
        System.out.printf("""
                [Время с момента старта часов]
                    Исходное: %d
                    +1: %d
                    -1: %d%n
                """, sinceLaunchTime, ++sinceLaunchTime, --sinceLaunchTime);

        System.out.println("\n7 ВЫВОД ПАРАМЕТРОВ JVM \n");
        Runtime rt = Runtime.getRuntime();
        int convertMegabyte = 1024 * 1024;
        int processors = rt.availableProcessors();
        long freeMemory = rt.freeMemory() / convertMegabyte;
        long totalMemory = rt.totalMemory() / convertMegabyte;
        long maxMemory = rt.maxMemory() / convertMegabyte;
        long usedMemory = (totalMemory - freeMemory) / convertMegabyte;
        System.out.printf("""
                Параметры JVM:
                Доступное число ядер: %d
                Выделенная память: %d Мб.
                Свободная память: %d Мб.
                Используемая память: %d Мб.
                Максимально доступная для выделения память: %d Мб.%n
                """, processors, totalMemory, freeMemory, usedMemory, maxMemory);

        System.out.println("\nВЫВОД ПАРАМЕТРОВ OC \n");
        char systemDisk = System.getProperty("user.home").charAt(0);
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String pathSeparetor = System.getProperty("file.separator");
        System.out.printf("""
                Параметры ОС:
                Системный диск: %s
                Версия ОС: %s
                Версия Java: %s
                Символ разделения пути: %s
                """, systemDisk, osVersion, javaVersion, pathSeparetor);

        System.out.println("\n8 ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА \n");
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        long finish = System.nanoTime();
        float timeElapsed = (finish - start);
        LocalTime endTime = LocalTime.now();
        System.out.printf("""
                | Старт проверки | %s |
                + -------------- + ------------ +
                | Финиш проверки | %s |
                + -------------- + ------------ +
                | Время работы   | %.3f сек    |
                """, dtf.format(startTime), dtf.format(endTime), timeElapsed / 1e9);
    }
}