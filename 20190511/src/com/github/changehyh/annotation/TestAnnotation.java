package com.github.changehyh.annotation;

public class TestAnnotation {
    @SuppressWarnings(value = {"unused","rawtypes"})
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);//toString()
    }
}

class Person {

    /**
     * 原因： 人得有名字
     * 替代方案：建议使用Person(String name)
     */
    @Deprecated
    public Person() {

    }

    public Person(String name) {
    }

    @Override
    public String toString() {
        return "比特人";
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
