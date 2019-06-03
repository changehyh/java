package com.changehyh.github.thread;

import com.changehyh.github.thread.MyThread;

public class TestMyThread {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("MyThread1");
        MyThread myThread2 = new MyThread("MyThread2");
        MyThread myThread3 = new MyThread("MyThread3");

        System.out.println("这是main方法开始");
        myThread1.start();
        myThread2.start();
        myThread3.start();
        System.out.println("这是main方法结束");
    }
}
