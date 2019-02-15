package com.ligz.a;

/**
 * 一个线程执行完毕之后会自动结束，如果在运行过程中发生异常也会提前结束
 * author:ligz
 */
public class InterruptExample {
    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //interrupt
        Thread thread1 = new MyThread1();
        thread1.start();
        thread1.interrupt();
        System.out.println("Main run");

        //interrupted
        Thread thread2 = new MyThread2();
        thread2.start();
        thread2.interrupt();
    }

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
                // ..
            }
            System.out.println("Thread end");
        }
    }
}
