package com.changehyh.github.classloader;

import java.lang.reflect.Method;

public class TestObject {

    public static void main(String[] args) {
        Class cls = Object.class;
        System.out.println(cls);
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods){
            System.out.println(method);
        }
    }
}
