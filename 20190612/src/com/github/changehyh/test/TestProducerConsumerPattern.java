package com.github.test;

import com.github.commen.Goods;
import com.github.consumer.Consumer;
import com.github.producre.Producer;

import java.util.LinkedList;
import java.util.Queue;

public class TestProducerConsumerPattern {
    public static void main1(String[] args) {
        //生产者
        //消费者
        //容器
        Queue<Goods> queue = new LinkedList<>();
        Runnable produce = new Producer(queue);
        Runnable consumer = new Consumer(queue);
        //生产者线程
        for (int i = 0; i < 5; i++) {
            new Thread(produce,"生产者-" + i).start();
        }
        //消费者
        for (int i = 0; i < 2; i++) {
            new Thread(consumer,"消费者-" + i).start();
        }
    }

    public static void main(String[] args) {
        //可配置
        //1.scanner键盘输入
        //2.file
        //3.properties(key=value)
        //4.command line arguments 命令行参数  java Main.class  a b c
        //5.数据库  mysql (JDBC)
        //6.System.env("")
        int defaultProducers = 5;
        int defaultConsumers = 5;
        int producers = defaultProducers;
        int consumers = defaultConsumers;
        if (args.length == 1){
            try{
                producers = Integer.getInteger(args[0]);
            }catch (NumberFormatException e){
                producers = defaultProducers;
            }
        }
        if (args.length == 2){
            try {
                producers = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                producers = defaultProducers;
            }
            try {
                consumers = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                consumers = defaultConsumers;
            }
        }
        if (producers <= 0) {
            producers = defaultProducers;//开发者，需求
        }
        if (consumers <= 0) {
            consumers = defaultConsumers;
        }
        ProducerConsumerLauncher.run(producers, consumers);
    }
}
