package com.github.consumer;

import com.github.commen.Goods;

import java.util.Queue;

public class Consumer implements Runnable{
    private final Queue<Goods> queue;

    public Consumer(Queue<Goods> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (queue){
            if (this.queue.isEmpty()){
                System.out.println(Thread.currentThread().getName() + "容器为空，停止消费 加速生成");
                this.queue.notifyAll();
            }else {
                Goods goods = this.queue.poll();
               if (goods != null) {
                   System.out.println(Thread.currentThread().getName() + "消费商品" + goods);
               }
            }
        }
    }

}
