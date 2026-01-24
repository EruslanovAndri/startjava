package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ElementRemoverByIndex {
    public static void main(String[] args) {
        double[] origin = fillArray();
        double[] changed = remove(origin, -1);
        print(origin, changed, -1);

        origin = fillArray();
        changed = remove(origin, 15);
        print(origin, changed, 15);

        origin = fillArray();
        changed = remove(origin, 0);
        print(origin, changed, 0);

        origin = fillArray();
        changed = remove(origin, 14);
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

    private static double[] remove(double[] origin, int index) {
        double[] changed = null;
        if (index < 0) {
            System.out.println("Ошибка! Индекс не может быть меньше 0.");
            return null;
        } else if (index > origin.length - 1) {
            System.out.println("Ошибка! Индекс больше длины массива.");
            return null;
        } else {
            double value = origin[index];
            changed = new double[origin.length];
            for (int i = 0; i < origin.length; i++) {
                if (value < origin[i]) {
                    changed[i] = 0;
                } else {
                    changed[i] = origin[i];
                }
            }
        }
        return changed;
    }

    private static void print(double[] origin, double[] changed, int index) {
        if (index >= 0 && index < origin.length) {
            System.out.println("\nИсходный массив:");
            for (int i = 0; i < 8; i++) {
                System.out.printf("%6.3f", origin[i]);
            }
            System.out.println();
            for (int i = 8; i < 15; i++) {
                System.out.printf("%6.3f", origin[i]);
            }
            System.out.printf("%n%s%.3f%n%n", " Значение из ячейки по переданному индексу = ", origin[index]);
            System.out.println("Измененный массив:");
            for (int i = 0; i < 8; i++) {
                System.out.printf("%6.3f", changed[i]);
            }
            System.out.println();
            for (int i = 8; i < 15; i++) {
                System.out.printf("%6.3f", changed[i]);
            }
            System.out.println();
        }
    }
}
