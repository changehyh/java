package com.changehyh.github.tick;

import java.util.concurrent.Callable;

public class MyTickCallable implements Callable {
    private int tick = 10;

    @Override
    public String call() {
        while (this.tick > 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Thread.currentThread().getName() 那个线程在执行代码 ，返回线程的名字
            synchronized (this){
                if (this.tick > 0){
                    System.out.println(Thread.currentThread().getName() + "买了一张票，剩余" + (--this.tick));
                }
                if (this.tick == 0){
                    System.out.println("main方法结束");
                }
            }
        }
        return "票卖光了";
    }
}
