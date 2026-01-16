package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ValueRemover {
    public static void main(String[] args) {
        double[] origin = fillArray();
        double[] changed = changeArray(origin, 14);
        print(origin, changed, 1);
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
        double[] changed = new double[origin.length];
        for (int i = 0; i < origin.length; i++) {
            if (i < index) {
                changed[i] = origin[i];
            } else {
                changed[i] = 0.0;
            }
        }
        return changed;
    }

    private static void print(double[] origin, double[] changed, int index) {
        System.out.println("Исходный массив: ");
        for (int i = 0; i < 8; i++) {
            System.out.print(origin[i] + " ");
        }
        System.out.println();
        for (int i = 8; i < 15; i++) {
            System.out.print(origin[i] + " ");
        }
        System.out.println("\nИзмененный массив: ");
        for (int i = 0; i < 8; i++) {
            System.out.print(changed[i] + " ");
        }
        System.out.println();
        for (int i = 8; i < 15; i++) {
            System.out.print(changed[i] + " ");
        }
        try {
            if (index <= changed.length) {
                System.out.println("\nЗначение из ячейки по переданному индексу = " + changed[index]);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nОшибка! Переданный индекс больше чем длина массива.");
        }

        for (double element : changed) {
            if (element * 1000 != 0) {
                System.out.print(element + " ");
            }
        }
    }
}
