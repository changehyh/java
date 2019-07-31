package Thread;


import java.util.concurrent.TimeUnit;

class JVMTask implements Runnable{
    private int ticket = 20;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "还剩下" + ticket-- + "票");
                }
            }
        }
    }
}
public class ExecutorTest {
    public static void main(String[] args) {
        JVMTask task = new JVMTask();
        new Thread(task,"黄牛A").start();
        new Thread(task,"黄牛B").start();
        new Thread(task,"黄牛C").start();
    }
}
