package com.changehyh.github;

import java.util.function.Predicate;

public class TestDemo4 {
    public static void main(String[] args) {
        Predicate<String> predicate =(x)-> {
            if (x==null){
                return false;
            }else {
                return x.length()>2;
            }
        };
        System.out.println(predicate.test("hello"));
        System.out.println(predicate.test(""));
    }
}
