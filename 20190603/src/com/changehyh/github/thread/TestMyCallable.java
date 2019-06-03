package com.changehyh.github.thread;

import com.changehyh.github.thread.MyCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestMyCallable {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();

        //Runnable  -> run  -> void
        //Callable  -> run (异步) -> V(int) 将来

        //FutureTask  -> Runnable
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);

        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            Integer sum = futureTask.get(1,TimeUnit.MILLISECONDS);
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("main结束");
    }
}
