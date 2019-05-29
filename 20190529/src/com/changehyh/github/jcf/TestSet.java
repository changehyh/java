package com.changehyh.github.jcf;




import java.util.*;

public class TestSet {
//    public static void main1(String[] args) {
//        Set<String> set = new HashSet<>();
//        set.add("Java");
//        set.add("C++");
//        set.add("PHP");
//        set.add("SQL");
//        set.add("JavaScript");
//        set.add("C");
//        set.add("Python");
//        set.add("C++");
//        set.add("C");// 9 2 ->7
//        System.out.println("集合元素个数:"+set.size());
//        System.out.println("集合是否为空："+set.isEmpty());
//        System.out.println("集合元素："+set);
//        System.out.println("移除元素："+set.remove("SQL"));
//        System.out.println("是否包含Java:"+set.contains("Java"));
//    }

    public static void main(String[] args) {
//        Set<Integer> set = new TreeSet<>();
//        set.add(50);
//        set.add(40);
//        set.add(30);
//        set.add(20);
//        System.out.println(set);

        Set<Person2> set = new TreeSet<>(new Comparator<Person2>() {
            @Override
            public int compare(Person2 o1, Person2 o2) {
                return Integer.compare(o1.getName().length()
                        ,o2.getName().length()); }
        });
        set.add(new Person2("Jack",23));
        set.add(new Person2("TOM",24));
        set.add(new Person2("Alice",21));
        set.add(new Person2("张三",27));
        System.out.println(set);
    }
}
