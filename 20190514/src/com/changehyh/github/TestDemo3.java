package com.changehyh.github;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.function.Consumer;

public class TestDemo3 {
    public static void main(String[] args) {
        Consumer<String> consumer = (x)->{
            System.out.println(x);
        };
        consumer.accept("xxx");
        //System.out.println();
        consumer = System.out::println;
    }
}
