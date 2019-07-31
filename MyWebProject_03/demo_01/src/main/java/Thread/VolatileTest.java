package Thread;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    private volatile int num = 0;
    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    try {
                        TimeUnit.MICROSECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.num++;
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(test.num);
    }
}
