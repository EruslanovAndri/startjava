package com.startjava.lesson_2_3_4.array;

import java.lang.reflect.Array;
import java.util.Random;

public class ElementRemoverByIndex {
    public static void main(String[] args) {
        float[] originArray = fillArray();
        float[] changedArray = remove(originArray, -1);
        printArray(originArray, changedArray, -1);

        originArray = fillArray();
        changedArray = remove(originArray, 15);
        printArray(originArray, changedArray, 15);

        originArray = fillArray();
        changedArray = remove(originArray, 0);
        printArray(originArray, changedArray, 0);

        originArray = fillArray();
        changedArray = remove(originArray, 14);
        printArray(originArray, changedArray, 14);
    }

    private static float[] fillArray() {
        Random random = new Random();
        float[] randomArray = new float[15];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextFloat();
        }
        return randomArray;
    }

    private static float[] remove(float[] originArray, int index) {
        if (index < 0) {
            System.out.println("Ошибка! Индекс (" + index + ") не может быть меньше 0.");
            return null;
        }
        if (index > originArray.length - 1) {
            System.out.println("Ошибка! Индекс (" + index + ") больше длины массива.");
            return null;
        }

        float valueByIndex = originArray[index];
        float[] changedArray = new float[originArray.length];
        System.arraycopy(originArray, 0, changedArray, 0, originArray.length);
        for (int i = 0; i < originArray.length; i++) {
            if (originArray[i] > valueByIndex) {
                changedArray[i] = 0;
            }
        }
        return changedArray;
    }

    private static void printArray(float[] originArray, float[] changedArray, int index) {
        String[] arrayName = {"Исходный массив.", "Измененный массив."};
        float[][] arrays = {originArray, changedArray};
        if (index >= 0 && index < originArray.length) {
            for (int i = 0; i < arrayName.length; i++) {
                System.out.println("\n" + arrayName[i]);
                for (int j = 0; j < 8; j++) {
                    System.out.printf("%6.3f", arrays[i][j]);
                }
                System.out.println();
                for (int j = 8; j < 15; j++) {
                    System.out.printf("%6.3f", arrays[i][j]);
                }
                if (i == 0) {
                    System.out.printf("%n%s%4.3f%n", "Переданный индекс = ", arrays[i][index]);
                }
            }
            System.out.println();
        }
    }
}
