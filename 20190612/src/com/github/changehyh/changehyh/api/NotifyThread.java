package com.github.changehyh.api;

public class NotifyThread extends Thread {
    private final Object object;

    public NotifyThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (this.object){
            System.out.println(Thread.currentThread().getName()+ "开始执行");
            this.object.notifyAll();
            System.out.println(Thread.currentThread().getName()+ "结束执行");
        }
    }
}
