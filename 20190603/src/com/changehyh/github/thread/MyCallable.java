package com.changehyh.github.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            sum += i;
        }
        Thread.sleep(1000);
        return sum;
    }
}
