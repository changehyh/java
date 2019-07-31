package Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class CDLTask implements Runnable{
    private CountDownLatch countDownLatch;

    public CDLTask(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "到达终点");
        countDownLatch.countDown();
    }
}

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        CDLTask task = new CDLTask(countDownLatch);
        System.out.println("比赛开始...");
        Thread thread = new Thread(task,"运动员A");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread thread1 = new Thread(task,"运动员B");
        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        Thread thread2 = new Thread(task,"运动员C");
        thread2.start();
        countDownLatch.await();
        TimeUnit.SECONDS.sleep(1);

    }
}
