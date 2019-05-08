package com.guthub.changhyh.until;

public class MyMath {
    public static int sum(int a, int b){
        return a + b;
    }
    public static int sub(int a, int b){
        return a - b;
    }
    public static int div(int a, int b){
        if (b==0){
            throw new IllegalArgumentException("b 作为除数不能为0");
        }
        return a / b;
    }
}
