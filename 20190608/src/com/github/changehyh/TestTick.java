package com.github.changehyh;

public class TestTick {
    public static void main(String[] args) {
        Runnable runnable = new Tick();
        Thread thread = new Thread(runnable,"黄牛A");
        Thread thread1 = new Thread(runnable,"黄牛B");

        thread.start();
        thread1.start();
    }
}
