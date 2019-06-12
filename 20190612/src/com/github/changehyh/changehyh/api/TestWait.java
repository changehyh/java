package com.github.changehyh.api;

public class TestWait {
    final static Object object = new Object();
    public static void code1(){
        synchronized (object){
            System.out.println("同步开始");
            try {
                object.wait();//必须放在同步方法中
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("同步结束");
        }
        System.out.println("main方法执行结束");
    }
    public static void main(String[] args) {

    }
}
