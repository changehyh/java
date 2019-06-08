package com.github.changehyh.sync;

public class TestSync {
    public static void main1(String[] args) {
        Sync sync = new Sync();
        for (int i = 0; i < 3; i++) {
            Thread thread = new SyncThread(sync);
            thread.setName("Thread-Sync-" + i);
            thread.start();
        }
    }
    public static void main(String[] args) {
        Sync1 sync1 = new Sync1();
        for (int i = 0; i < 3; i++) {
            Thread thread = new SyncThread1(sync1);
            thread.setName("Thread-Sync-" + i);
            thread.start();
        }
    }
    public static void main2(String[] args) {
        Sync2 sync2 = new Sync2();
        for (int i = 0; i < 3; i++) {
            Thread thread = new SyncThread2(sync2);
            thread.setName("Thread-Sync-" + i);
            thread.start();
        }
    }
}

class Sync{
    //多线程访问同一个Sync对象的test方法，同一时间只能有一个线程方法
    //成员方法（非静态方法）=> 类的实例化对象
    //静态方法 => 类
    public synchronized void test(){
        System.out.println("Sync test 方法在线程" +
                Thread.currentThread().getName() + "开始执行");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sync test 方法在线程" +
                Thread.currentThread().getName() + "结束运行");
    }
}
class SyncThread extends Thread{
    private final Sync sync;

    SyncThread(Sync sync) {
        this.sync = sync;
    }

    @Override
    public void run() {
        sync.test();
    }
}

class Sync1{
    //Sync1.class -> 只有一个
    //Sync1.class -> Class 对象  -> Sync1 -> 全局锁
    public void test(){
        synchronized (Sync1.class) {
            System.out.println("Sync test 方法在线程" +
                    Thread.currentThread().getName() + "开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sync test 方法在线程" +
                    Thread.currentThread().getName() + "结束运行");
        }
    }
}
class SyncThread1 extends Thread{
    private final Sync1 sync;

    SyncThread1(Sync1 sync) {
        this.sync = sync;
    }


    @Override
    public void run() {
        synchronized (sync){
            sync.test();
        }
    }
}

class Sync2{
    //多线程
    public void test(){
        synchronized (Sync2.class){
            System.out.println("Sync test 方法在线程" +
                    Thread.currentThread().getName() + "开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sync test 方法在线程" +
                    Thread.currentThread().getName() + "结束运行");
        }
    }
}

class SyncThread2 extends Thread{
    private final Sync2 sync;

    SyncThread2(Sync2 sync) {
        this.sync = sync;
    }
    @Override
    public void run() {
        sync.test();
    }
}