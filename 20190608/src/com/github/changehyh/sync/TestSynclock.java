package com.github.changehyh.sync;

public class TestSynclock {
    public static void main(String[] args) {
        final Object lock = new Object();//同一个对象

            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "线程开始");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "线程结束");
                    }
                }
            }, "线程A").start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + "线程开始");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "线程结束");
                    }
                }
            }, "线程B").start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + "线程开始");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "线程结束");
                    }
                }
            }, "线程C").start();
        }
}
