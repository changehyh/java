package com.changehyh.github.annotation;

public class TestFactory {
    public static void main(String[] args) {

        Fruit fruit = Factory.getFruit();
        if (fruit != null){
            fruit.eat();
        }
    }
}
