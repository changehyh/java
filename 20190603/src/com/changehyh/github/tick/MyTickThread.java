package com.changehyh.github.tick;

public class MyTickThread extends Thread{
    private int tick = 10;

    private  String title;

    public MyTickThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {
      while (this.tick > 0){
          System.out.println(this.title + "买了一张票，剩余" + (--this.tick));
      }
    }
}
