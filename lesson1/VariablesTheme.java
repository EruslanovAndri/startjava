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
        a += b;
        b -= a;
        b *= -1;
        a -= b;
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
                (char) codeAsciiOne, (char) codeAsciiTwo,
                (char) codeAsciiThree, (char) codeAsciiFour,
                (char) codeAsciiFive, (char) codeAsciiSix, "\n");

        System.out.println("\n5 АНАЛИЗ КОДА ТОВАРА \n");
        int productCode = 123;
        int productCategory = productCode / 100 % 10;
        int subcategoryCode = productCode / 10 % 10;
        int packageType = productCode % 10;
        int checksum = productCategory + subcategoryCode + packageType;
        int verificationCode = productCategory * subcategoryCode * packageType;
        System.out.printf("%s %d %n %25s %d %n %21s %5d %n %17s %9d %n %s %d %n %s %d %n",
                "Код товара:", productCode,
                "категория товара - ", productCategory,
                "подкатегория - ", subcategoryCode,
                "упаковка - ", packageType,
                "Контрольная сумма: ", checksum,
                "Проверочный код: ", verificationCode, "\n");

        System.out.println("\n6 ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ \n");
        byte temperature = Byte.MAX_VALUE;
        int symbolTemp = 176;
        System.out.printf("%s %c %s %s %n %15s %d",
                "[Температура, ", (char) symbolTemp, "C", "]",
                "Исходное: ", temperature);
        temperature++;
        System.out.printf("%n %8s %d", "+1:", temperature);
        temperature--;
        System.out.printf("%n %8s %d", "-1:", temperature);
        short pressure = Short.MAX_VALUE;
        System.out.printf("%n %s %s %n %14s %d",
                "[Давление, PA", "]",
                "Исходное:", pressure);
        pressure++;
        System.out.printf("%n %8s %d", "+1:", pressure);
        pressure--;
        System.out.printf("%n %8s %d", "-1:", pressure);
        char myChar = Character.MAX_VALUE;
        System.out.printf("%n %s %s %n %14s %d",
                "[Код состояния системы,", "]",
                "Исходное:", (int) myChar);
        myChar++;
        System.out.printf("%n %8s %d", "+1:", (int) myChar);
        myChar--;
        System.out.printf("%n %8s %d", "-1:", (int) myChar);
        int traveledDistance = Integer.MAX_VALUE;
        System.out.printf("%n %s %s %s %n %15s %d",
                "[Пройденное расстояние,", "км", "]",
                "Исходное: ", traveledDistance);
        traveledDistance++;
        System.out.printf("%n %8s %d", "+1:", traveledDistance);
        traveledDistance--;
        System.out.printf("%n %8s %d", "-1:", traveledDistance);
        long timeSinceLaunch = Long.MAX_VALUE;
        System.out.printf("%n %s %s %s %n %15s %d",
                "[Время с момента старта,", "часов", "]",
                "Исходное:", timeSinceLaunch);
        timeSinceLaunch++;
        System.out.printf("%n %8s %d", "+1:", timeSinceLaunch);
        timeSinceLaunch--;
        System.out.printf("%n %8s %d %n", "-1:", timeSinceLaunch, "\n");

        System.out.println("\n7 ВЫВОД ПАРАМЕТРОВ JVM \n");
        int processors = Runtime.getRuntime().availableProcessors();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.printf("%s %n %5s %d %n %5s %.1f %s %n %s %.1f %s %n %5s %.1f %s %n %5s %.1f %s %n",
                "Параметры JVM:",
                "Доступное число ядер - ", processors,
                "Выделенная память - ",
                (float) maxMemory / (1024 * 1024), "Мб",
                "Свободная память - ",
                (float) freeMemory / (1024 * 1024), "Мб",
                "Используемая память - ",
                (float) (maxMemory - freeMemory) / 1_048_576, "Мб",
                "Максимально доступная для выделения память - ",
                (float) (maxMemory + freeMemory) / 1_048_576, "Мб", "\n");

        System.out.println("\n8 ВЫВОД ПАРАМЕТРОВ OC \n");
        String systemDisk = System.getProperty("java.vendor");
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String pathSeparetor = System.getProperty("file.separator");
        System.out.printf("%s %n %5s %s %n %5s %s %n %5s %s %n %5s %s %n",
                "Параметры ОС:",
                "Системный диск - ", systemDisk,
                "Версия ОС - ", osVersion,
                "Версия Java - ", javaVersion,
                "Символ разделения пути - ", pathSeparetor, "\n");

        System.out.println("\n9 ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА \n");
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        LocalTime endTime = LocalTime.now();
        System.out.printf("%16s %s %n %s %s %n %s %.3f",
                "Старт проверки:", dtf.format(startTime),
                "Финиш проверки:", dtf.format(endTime),
                "Время работы:", (float) timeElapsed / 1_000_000_000);
        System.out.printf("%n %s %.3f %s", "Time =", (float) timeElapsed / 1_000_000_000, "sec");
    }
}