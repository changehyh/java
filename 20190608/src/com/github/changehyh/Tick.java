package com.github.changehyh;


public class Tick implements Runnable{

    @Override
    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}

class Sync {
    private int tick = 10;

    void test() {

        while (this.tick > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Sync.class) {
                if (this.tick > 0) {
                    System.out.println(Thread.currentThread().getName() + "买了票，还剩" + (--this.tick));
                }
            }
        }
    }
}


//    @Override
//    public void run() {
//        while (this.tick > 0) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            this.sale();
//        }
//    }
    //同步方法
//    private static synchronized void sale(){
//        if (this.tick> 0){
//            System.out.println(Thread.currentThread().getName()+"买了一张票，剩余" + (--this.tick));
//        }
//    }

//    private synchronized void sale1(){
//        if (this.tick> 0){
//            System.out.println(Thread.currentThread().getName()+"买了一张票，剩余" + (--this.tick));
//        }
//    }


//    @Override
//    public void run() {
//        while (this.tick > 0){
//          try {
//             Thread.sleep(1000);
//          } catch (InterruptedException e) {
//             e.printStackTrace();
//          }
//          //同步对象
//          synchronized (this){
//              if (this.tick >0){
//                  System.out.println(Thread.currentThread().getName()+"买了一张票，剩余" + (--this.tick));
//              }
//          }
//        }
//    }



