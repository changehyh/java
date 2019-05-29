package com.changehyh.github.jcf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {
    public static void main1(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add(0,"C++");
        list.add("PHP");
        list.add("PHP");
//        System.out.println(list);
//        System.out.println(list.size());
//        System.out.println(list.contains("PHP"));
//        System.out.println(list.remove("PHP"));
//        System.out.println(list);

//        for (int i = 0; i <list.size() ; i++) {
//            System.out.println(list.get(i));
//        }

//        for (String aList : list) {
//            System.out.println(aList);
//        }
        Object[] objects = list.toArray();
//        for (Object object:objects) {
////            System.out.println(object);
////        }
////        System.out.println(objects);

        System.out.println(Arrays.toString(objects));
    }

    public static void main(String[] args) {

    }
}

