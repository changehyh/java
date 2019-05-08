package com.guthub.changhyh;

public class TestForeach {
    public static void main(String[] args) {
        int[]data=new int []{1,2,3,4,5};
        int sum = 0;
        int index = 0;
        for (int aData : data) {
            sum += aData;
            System.out.println("index="+index+"value="+aData);
            index++;
        }
        System.out.println("sum"+sum);
    }
}
