package com.changehyh.github.reflect;

import javax.xml.crypto.Data;
import java.util.Date;

public class TestReflect {
    public static void ThreadGet(String[] args) {
        //Date
        //java.util.Date

        Date date  = new Date();//创建对象

        //类型
        //class 关键字
        //Class 类型
        // Class toString()
        //1
        Class aClass = date.getClass();
        System.out.println(aClass);

        //2
        System.out.println(date instanceof Date);
        Class classz = Date.class;
        System.out.println(classz);


        //3
        try {
        Class classzz = Class.forName("java.util.Date");
            System.out.println(classzz);
            System.out.println("-----------------");
            //3种方式
            //当前三个Class对象  都是描述java.util.Date
            System.out.println(aClass==classz);
            System.out.println(classz==classzz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
