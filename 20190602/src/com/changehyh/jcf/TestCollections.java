package com.biitech.jcf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Author: secondriver
 * Created: 2019/6/1
 */
public class TestCollections {
    
    public static void code1() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "C++", "PHP");
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
    
    public static void code2() {
        List list = Collections.emptyList();
//        list.add("Java"); UnsupportedOperationException
        System.out.println(list.isEmpty());
    }
    
    public static void code3() {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            integers.add(random.nextInt(100));//[0,100]
        }
        System.out.println(integers);
        
        Integer maxValue = Collections.max(integers);// Integer Comparable
        System.out.println(maxValue);
    }
    
    public static void code4(){
        List<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= 54; i++) {
            integers.add(i);
        }
        System.out.println(integers);
    
        Collections.shuffle(integers);
        System.out.println(integers);
    
        Collections.shuffle(integers);
        System.out.println(integers);
    }
    
    public static void main(String[] args) {
    
//        Map<Integer,String> map = new HashMap<>();
//        map.put(1,"666");
        Map<Integer,String> map=  Collections.singletonMap(1,"666");
        System.out.println(map);

        //UnsupportedOperationException
//        map.put(2,"777");
    }
}
