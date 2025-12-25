package com.startjava.lesson_2_3.method.naming;

import java.lang.reflect.Method;

public class Methods {
    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}