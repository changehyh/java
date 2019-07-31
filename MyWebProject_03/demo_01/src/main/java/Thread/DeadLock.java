package Thread;
//死锁
class Pen{};

class Book{};

public class DeadLock {
    public static void main(String[] args) {
        final Pen pen = new Pen();
        final Book book = new Book();
        Thread penThread = new Thread(() ->{
            synchronized (pen){
                System.out.println("我有笔，把本给我");
                synchronized (book){
                    System.out.println("把你的本给我");
                }
            }
        });
        Thread bookThread = new Thread(() ->{
            synchronized (book){
                System.out.println("我有本，把笔给我");
                synchronized (pen){
                    System.out.println("把你的笔给我");
                }
            }
        });
        penThread.start();
        bookThread.start();
    }
}
