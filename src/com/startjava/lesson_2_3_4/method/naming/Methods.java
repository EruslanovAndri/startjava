package com.startjava.lesson_2_3_4.method.naming;

public class Methods {
    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}