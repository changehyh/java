package com.guthub.changhyh;

public class TestVarArgs {
//    //任意整数求和
//    public static int sum(int[] data){
//        int sum = 0;
//        for (int i = 0; i < data.length; i++) {
//            sum += data[i];
//        }
//        return sum;
//    }
    public static int sum(String msg, int... data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }
        public static void main(String[] args) {
        System.out.println(sum("hello"));
        System.out.println(sum("hello",1,2));
        System.out.println(sum("hello",new int[]{1,2,3}));
    }
}
