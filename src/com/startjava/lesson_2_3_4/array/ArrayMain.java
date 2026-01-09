package com.startjava.lesson_2_3_4.array;

/** @noinspection ALL*/
public class ArrayMain {
    public static void main(String[] args) {
        int[] numbers = new int[6];
        float[] numbers1 = {5.1f, 2.3f, .5f, 200.13f};
        System.out.println(numbers.length);
        System.out.println(numbers1.length);
        int incr = 1;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = incr;
            System.out.print(numbers[i] + " ");
            incr++;
        }
    }
}
