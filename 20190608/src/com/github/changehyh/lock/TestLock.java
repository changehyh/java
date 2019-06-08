package com.github.changehyh.lock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestLock {
       // private static StringBuffer sb = new StringBuffer();
    private final static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        synchronized (sb){
            sb.append("a");
            sb.append("b");
            sb.append("c");
        }
        System.out.println(sb.toString());
//        StringBuilder sb = new StringBuilder();
//
//            sb.append("a");
//            sb.append("b");
//            sb.append("c");
//
//        System.out.println(sb.toString());

//        SimpleDateFormat simpleDateFormat = new
//                SimpleDateFormat("yyyy-MM-dd");
//        String str = simpleDateFormat.format(new Date());
//        System.out.println(str);
    }
}
