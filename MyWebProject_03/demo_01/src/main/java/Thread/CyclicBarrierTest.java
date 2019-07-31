package Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

class CBTask implements Runnable{
    private CyclicBarrier cyclicBarrier;
    public  CBTask(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在写入数据。。。");
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "写入完毕，等待其他线程完毕");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程均已将数据写完，同时恢复执行。。。");
    }
}
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,() ->{
            System.out.println("当前线程为" + Thread.currentThread().getName());
        });
        CBTask cbTask = new CBTask(cyclicBarrier);
        for (int i = 0; i < 3; i++) {
            new Thread(cbTask,"写入线程"+(i+1)).start();
        }
    }
}
