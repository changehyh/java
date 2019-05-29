package com.changehyh.github.jcf;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"java");
        map.put(2,"C");
        map.put(3,"Python");
        map.put(4,"C++");
        map.put(5,null);
        map.put(6,"Python");
        map.put(1,"PHP");
        map.put(null,"SQL");
        System.out.println(map);
        System.out.println("集合元个数："+map.size());
        System.out.println("集合是否为空："+map.isEmpty());



    }
}
