package com.github.producre;

import com.github.commen.Goods;

import java.util.Queue;
import java.util.Random;
import java.util.UUID;


public class Producer implements Runnable{

    private final Queue<Goods> queue;

    public Producer(Queue<Goods> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.queue){
                if (this.queue.size() >= 10){
                    System.out.println(Thread.currentThread().getName() + "容器已满，停止生产" +
                            "等待加快消费");
                    try {
                        this.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    Goods goods = new Goods();
                    String id = UUID.randomUUID().toString();
                    String name = "包子";
                    Double price = 2.5;
                    goods.setId(id);
                    goods.setName(name);
                    goods.setPrice(price);
                }
            }
        }
    }
}
