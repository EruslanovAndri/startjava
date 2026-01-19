package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ElementRemoverByIndex {
    public static void main(String[] args) {
        double[] origin = fillArray();
        double[] changed = remove(origin, -1);
        print(origin, -1);
        print(changed, -1);

        origin = fillArray();
        changed = remove(origin, 15);
        print(origin, 15);
        print(changed, 15);

        origin = fillArray();
        changed = remove(origin, 0);
        print(origin,  0);
        print(changed, 0);

        origin = fillArray();
        changed = remove(origin, 14);
        print(origin, 14);
        print(changed, 14);
    }

    private static double[] fillArray() {
        Random random = new Random();
        double[] randomArray = new double[15];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextDouble(0, 1);
        }
        return randomArray;
    }

    private static double[] remove(double[] origin, int index) {
        if (index < 0) {
            System.out.println("\t Ошибка! Индекс не может быть меньше 0.\n");
        } else {
            double[] changed = new double[origin.length];
            for (int i = 0; i < origin.length; i++) {
                if (i <= index) {
                    changed[i] = origin[i];
                } else {
                    changed[i] = 0;
                }
            }
            return changed;
        }
        return null;
    }

    private static void print(double[] array, int index) {
        if (index >= 0) {
            for (int i = 0; i < 8; i++) {
                System.out.printf("%10.3f", array[i]);
            }
            System.out.println();
            for (int i = 8; i < 15; i++) {
                System.out.printf("%10.3f", array[i]);
            }
            System.out.println();
            if (index != array.length) {
                System.out.printf("%s%7.3f", "\t Значение из ячейки по переданному индексу =", array[index]);
                System.out.println();
            } else {
                System.out.printf("%s%7.3f", "\t Значение из ячейки по переданному индексу =", array[--index]);
                System.out.println();
            }
            System.out.println();
        }
    }
}
