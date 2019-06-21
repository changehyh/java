package com.github.changehyh;

public class TestVolatile {
        private static volatile int num = 0;
        private static void increase() {
            num++;
        }
        public static void main(String[] args) {
            Thread[] threads = new Thread[10];
            for (int i = 0; i < 10; i++) {
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int j = 0; j < 100; j++) {
                            increase();
                        }
                    }
                });
                threads[i].start();
            }
            while (Thread.activeCount() > 2) {
                Thread.yield();
            }
            System.out.println(num);
        }
}
