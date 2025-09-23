import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VariablesTheme {
    public static void main(String[] args) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

        final LocalTime startTime = LocalTime.now();
        
        final long start = System.nanoTime();

        System.out.println("ВЫВОД ASCII-ГРАФИКИ");

        System.out.println("первый (с помощью конкатенации)");

        System.out.print("                       " + "/" + "\\" + "\n" + "    " + 
                        "j" + "    " + "a" + "  " + "v" + "       " +
                        "v" + " " + "/" + " " + " \\" + "\n" + "    " + "j" + "   " + 
                        "a" + " " + "a" + "  " + "v" + "     " +
                        "v" + " " + "/" + "" + "_" + "(" + " " + ")" + "" +
                        "\\" + "\n" + "j" + "   " + "j" + "  " + "aaaaa" +
                        "  " + "V" + "   " + "V" + " " + "/" + "      " + 
                        "\\" + "\n" + "  " + "jj" + "  " + "a" + "     " + 
                        "a" + "   " + "V" + "  " + "/" + "___" + "/" + "\\" + 
                        "___" + "\\" + "\n");

        System.out.println("второй (с помощью текстового блока)");

        String block = 
                """
                                    /\\
                j    a   v     v   /  \\
                j   a a   v   v   /_( )\\
            j   j  aaaaa   V V   /      \\
              jj  a     a   V   /___/\\___\\
                """.indent(4);

        System.out.println(block);

        System.out.println("РАСЧЕТ СТОИМОСТИ ТОВАРА \n ");

        System.out.println("Первый вариант решения.");

        float costPen = 105.5f; 

        float costBook = 235.23f;

        int discount = 11;

        float costItems = costPen + costBook;

        float sumDiscount = (costItems / 100) * discount;

        float costDiscountedItem = costItems - sumDiscount;

        System.out.println("Общая стоимость товара = " + costItems);

        System.out.println("Сумма скидки = " + sumDiscount);

        System.out.println("Стоимость товара со скидкой = " + costDiscountedItem);

        System.out.println(" \n Второй вариант решения.");

        var costPenBd = new BigDecimal("105.5");

        var costBookBd = new BigDecimal("235.23");

        var discountBd = new BigDecimal("11");

        var costItemsBd = costPenBd.add(costBookBd);

        var sumDiscountBd = costItemsBd.divide(new BigDecimal("100"), 2,
                RoundingMode.HALF_UP).multiply(discountBd);

        var costDiscountedItemBd = costItemsBd.subtract(sumDiscountBd);

        System.out.println("Общая стоимость товара = " + costItemsBd);

        System.out.println("Сумма скидки = " + sumDiscountBd);

        System.out.println("Стоимость товара со скидкой = " + costDiscountedItemBd);

        System.out.println(" \n ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ \n ");

        System.out.println("С помощью третьей переменной");

        int a = 2;

        int b = 5;

        int tmp = 0;

        tmp = a;

        a = b;

        b = tmp;

        System.out.println("Метод : переменная.");

        System.out.println("Результат: A = " + a + " B = " + b);

        System.out.println(" \n С помощью арифметических операций");

        a = a + b; 

        b = a - b;

        a = a - b;

        System.out.println("Метод : арифмитический.");

        System.out.println("Результат: A = " + a + " B = " + b);

        System.out.println(" \n С помощью побитовых операций");

        a = a ^ b;

        b = a ^ b;

        a = a ^ b;

        System.out.println("Метод : побитовый.");

        System.out.println("Результат: A = " + a + " B = " + b);

        System.out.println(" \n ДЕКОДИРОВАНИЕ СООБЩЕНИЯ \n ");

        int codeAsciiOne = 1055;

        int codeAsciiTwo = 1088;

        int codeAsciiThree = 1080;

        int codeAsciiFour = 1074;

        int codeAsciiFive = 1077;

        int codeAsciiSix = 1090;

        char ch1 = (char) codeAsciiOne;

        char ch2 = (char) codeAsciiTwo;

        char ch3 = (char) codeAsciiThree;

        char ch4 = (char) codeAsciiFour;

        char ch5 = (char) codeAsciiFive;

        char ch6 = (char) codeAsciiSix;

        System.out.printf("%-5s %n", "ASCII Code");

        System.out.println("-----------");

        System.out.printf("%n %d %n %d %n %d %n %d %n %d %n %d %n",
                        codeAsciiOne, codeAsciiTwo, codeAsciiThree,
                        codeAsciiFour, codeAsciiFive, codeAsciiSix);

        System.out.println();

        System.out.printf("%-5s %10s %n ", "ASCII Code", "ASCII Code конвертируемый в символы");

        System.out.println("-----------");

        System.out.printf("%n %d %5c %n %d %5c %n %d %5c %n %d %5c %n %d %5c %n %d %5c",
                        codeAsciiOne, ch1, codeAsciiTwo, ch2, codeAsciiThree, ch3,
                        codeAsciiFour, ch4, codeAsciiFive, ch5, codeAsciiSix, ch6);

        System.out.println(" \n АНАЛИЗ КОДА ТОВАРА \n");

        int codeProduct = 123;

        int categoryProduct = codeProduct / 100 % 10;

        int codeSubcategory = codeProduct / 10 % 10;

        int typePackage = codeProduct % 10;

        int checkSum = categoryProduct + codeSubcategory + typePackage;

        int codeVerification = categoryProduct * codeSubcategory * typePackage;

        System.out.printf("%s %d %n %25s %d %n %21s %5d %n %17s %9d %n %s %d %n %s %d",
                    "Код товара:", codeProduct,
                    "категория товара - ", categoryProduct,
                    "подкатегория - ", codeSubcategory,
                    "упаковка - ", typePackage,
                    "Контрольная сумма: ", checkSum,
                    "Проверочный код: ", codeVerification);

        System.out.println(" \n ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ \n ");

        byte temperature = Byte.MAX_VALUE;

        int symbolTemp = 176;

        System.out.printf("%s %c %s %s %n %15s %d",
                    "[ Температура, ", (char) symbolTemp, "C", "]",
                    "Исходное: ", temperature);

        temperature++;

        System.out.printf("%n %8s %d", "+1:", temperature);

        temperature--;

        System.out.printf("%n %8s %d", "-1:", temperature);

        System.out.println("\n");

        short pressure = Short.MAX_VALUE;

        System.out.printf("%s %s %n %14s %d",
                    "[ Давление, PA", "]",
                    "Исходное:", pressure);

        pressure++;

        System.out.printf("%n %8s %d", "+1:", pressure);

        pressure--;

        System.out.printf("%n %8s %d", "-1:", pressure);

        System.out.println("\n");

        char myChar = Character.MAX_VALUE;

        System.out.printf("%s %s %n %14s %d",
                    "[ Код состояния системы,", "]",
                    "Исходное:", (int) myChar);

        myChar++;

        System.out.printf("%n %8s %d", "+1:", (int) myChar);

        myChar--;

        System.out.printf("%n %8s %d", "-1:", (int) myChar);

        System.out.println("\n");

        int traveledDistance = Integer.MAX_VALUE;

        System.out.printf("%s %s %s %n %15s %d",
                        "[ Пройденное расстояние,", "км", "]",
                        "Исходное: ", traveledDistance);

        traveledDistance++;

        System.out.printf("%n %8s %d", "+1:", traveledDistance);

        traveledDistance--;

        System.out.printf("%n %8s %d", "-1:", traveledDistance);

        System.out.println("\n");

        long timeSinceLaunch = Long.MAX_VALUE;

        System.out.printf("%s %s %s %n %15s %d",
                        "[ Время с момента старта,", "часов", "]",
                        "Исходное:", timeSinceLaunch);

        timeSinceLaunch++;

        System.out.printf("%n %8s %d", "+1:", timeSinceLaunch);

        timeSinceLaunch--;

        System.out.printf("%n %8s %d", "-1:", timeSinceLaunch);

        System.out.println(" \n ВЫВОД ПАРАМЕТРОВ JVM \n ");

        int processors = Runtime.getRuntime().availableProcessors();

        long freeMemory = Runtime.getRuntime().freeMemory();

        long totalMemory = Runtime.getRuntime().totalMemory();

        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.printf("%s %n %5s %d %n %5s %.1f %s %n %s %.1f %s %n %5s %.1f %s %n %5s %.1f %s",
                        "Параметры JVM:",
                        "Доступное число ядер - ", processors,
                        "Выделенная память - ",
                        (float) maxMemory / (1024 * 1024), "Мб",
                        "Свободная память - ",
                        (float) freeMemory / (1024 * 1024), "Мб",
                        "Используемая память - ",
                        (float) (maxMemory - freeMemory) / 1_048_576, "Мб",
                        "Максимально доступная для выделения память - ",
                        (float) (maxMemory + freeMemory) / 1_048_576, "Мб");

        System.out.println(" \n ВЫВОД ПАРАМЕТРОВ OC \n ");

        String systemDisk = System.getProperty("java.vendor");

        String osVersion = System.getProperty("os.version");

        String javaVersion = System.getProperty("java.version");

        String pathSeparetor = System.getProperty("file.separator");

        System.out.printf("%s %n %5s %s %n %5s %s %n %5s %s %n %5s %s",
                        "Параметры ОС:",
                        "Системный диск - ", systemDisk,
                        "Версия ОС - ", osVersion,
                        "Версия Java - ", javaVersion,
                        "Символ разделения пути - ", pathSeparetor);

        System.out.println(" \n ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА \n ");

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