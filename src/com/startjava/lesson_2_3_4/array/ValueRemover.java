package com.startjava.lesson_2_3_4.array;

import java.text.DecimalFormat;
import java.util.Random;

public class ValueRemover {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.###");

    public static void main(String[] args) {
        double[] origin = fillArray();
        double[] changed = changeArray(origin, -1);
        print(origin, changed, -1);

        System.out.println("**************************");
        changed = changeArray(origin, 15);
        print(origin, changed, 15);

        System.out.println("**************************");
        changed = changeArray(origin, 0);
        print(origin, changed, 0);

        System.out.println("**************************");
        changed = changeArray(origin, 14);
        print(origin, changed, 14);
    }

    private static double[] fillArray() {
        Random random = new Random();
        double[] randomArray = new double[15];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextDouble(0, 1);
        }
        return randomArray;
    }

    private static double[] changeArray(double[] origin, int index) {
        if (index < 0) {
            System.out.println("Ошибка! Индекс не может быть меньше 0.");
        } else {
            double[] changed = new double[origin.length];
            for (int i = 0; i < origin.length; i++) {
                if (i < index) {
                    changed[i] = origin[i];
                } else {
                    changed[i] = 0;
                }
            }
            return changed;
        }
        return null;
    }

    private static void print(double[] origin, double[] changed, int index) {
        if (index >= 0) {
            System.out.println("Исходный массив: ");
            for (int i = 0; i < 8; i++) {
                String value = DECIMAL_FORMAT.format(origin[i]);
                System.out.print(value + " ");
            }
            System.out.println();
            for (int i = 8; i < 15; i++) {
                String value = DECIMAL_FORMAT.format(origin[i]);
                System.out.print(value + " ");
            }
            System.out.println("\nИзмененный массив: ");
            for (int i = 0; i < 8; i++) {
                String value = DECIMAL_FORMAT.format(changed[i]);
                System.out.print(value + " ");
            }
            System.out.println();
            for (int i = 8; i < 15; i++) {
                String value = DECIMAL_FORMAT.format(changed[i]);
                System.out.print(value + " ");
            }
            System.out.println();
            if (index != origin.length) {
                String value = DECIMAL_FORMAT.format(origin[index]);
                System.out.println("Значение из ячейки по переданному индексу = " + value);
            } else {
                String value = DECIMAL_FORMAT.format(origin[--index]);
                System.out.println("Значение из ячейки по переданному индексу = " + value);
            }
        }
    }
}
