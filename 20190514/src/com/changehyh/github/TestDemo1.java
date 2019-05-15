package com.changehyh.github;

import java.util.function.Function;
import java.util.function.IntFunction;

public class TestDemo1 {
    public static void main(String[] args) {
        Function<Integer,String> fun = String::valueOf;
        System.out.println(fun.apply(1000));
//        IntFunction<String> fun =String::valueOf;
//        System.out.println(fun.apply(1000));

        print(String::valueOf,20);
    }
    public static void print(Function<Integer,String> function,Integer p){
        System.out.println(function.apply(p));
    }
}
