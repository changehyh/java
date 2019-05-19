package com.change.github.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class TestClass {
    public static void part1(){
        //1. new Test().getClass();
        //2. Test.class
        //3. Class.forName("com.bittech.reflect.Test")
        Class cls = Test.class;

        System.out.println("包名：" + cls.getPackage());
        System.out.println("父类：" + cls.getSuperclass().getName());//类的全限名  包名.类名
        System.out.println("父类：" + cls.getSuperclass().getSimpleName());//类名
        System.out.println("接口：" );
        //实例化
        Class[] interfaces = cls.getInterfaces();
        for (Class clsz:interfaces){
            System.out.println(clsz.getName());
            System.out.println(clsz.getSimpleName());
        }
    }
    public static void main(String[] args) {
        //Test1(int a, int b);    => Test1(int, int) => Test1(int.class, int.class)
        //Test1(int a, String b); => Test1(int,String)
        //Test1(int a);           => Test1(int)
        Class clz = Test.class;
        Constructor[] constructors = clz.getConstructors();
        System.out.println("获取所有的构造方法");
        for (Constructor constructor:constructors){
            Class [] parameterCls= constructor.getParameterTypes();
            String parameter = Arrays.toString(parameterCls);
            System.out.println(
                    constructor.getName() + "("+parameter+")"
            );
        }

        System.out.println("获取指定的构造方法");
        try {
            /*
            Constructor constructor = clz.getConstructor(Integer.class,String.class);
            System.out.println(constructor);

            //通过Constructor实例化对象
            //new Test(...)
                Object object = constructor.newInstance(20,"java");
                System.out.println(object.getClass());
            */
            Constructor constructor =clz.getConstructor(Integer.class,Integer.class);
            System.out.println(constructor);

            //通过Constructor实例化对象
            //new Test(...)
            Object object = constructor.newInstance(20,22);
            System.out.println(object.getClass());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

interface Fruit{

}

interface Message{

}

//com.changehyh.github.reflect
class Test implements Fruit,Message{
    public Test(Integer a,Integer b){

    }
    public Test(Integer a,String b){

    }
    public Test(Integer a){

    }
    public Test(){

    }
}