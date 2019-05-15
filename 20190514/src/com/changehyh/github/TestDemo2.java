package com.changehyh.github;

import java.util.function.Supplier;

public class TestDemo2 {
    public static void main(String[] args) {
        Supplier<String> supplier = ()->{
          return "Hello World";
        };
        System.out.println(supplier.get());

        print(Object::new);
    }

    public static void print(Supplier<?>supplier){
        System.out.println(supplier);
    }
}
