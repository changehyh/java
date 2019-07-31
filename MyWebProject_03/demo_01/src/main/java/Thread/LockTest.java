package Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//非阻塞式获取锁,若获取锁失败，线程继续执行，不再阻塞
//2.2 boolean tryLock();

//支持超时,获取锁失败的线程等待一段时间后若还获取到锁，线程退出
//2.3 boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
class Task implements Runnable{
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        boolean isLock = false;
        try {
           if (lock.tryLock(2,TimeUnit.SECONDS)){
               System.out.println(Thread.currentThread().getName() +
               "获取锁成功");
               TimeUnit.SECONDS.sleep(1);
               isLock = true;
            }else {
               System.out.println(Thread.currentThread().getName() +
               "获取锁失败");
           }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (isLock) {
                lock.unlock();
                System.out.println("锁已释放");
            }
        }
    }
}
public class LockTest {
    public static void main1(String[] args) {
        Object object = new Object();
        Thread thread = new Thread(() ->{
            while (true){
                synchronized (object){

                }
            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程中断");
        if (thread.isInterrupted()){
        }thread.interrupt();
    }

    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task,"线程A");
        Thread thread1 = new Thread(task,"线程B");
        thread.start();
        thread1.start();
    }
}
