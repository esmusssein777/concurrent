package com.ligz.acq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore(信号量)-允许多个线程同时访问
 * synchronized 和 ReentrantLock 都是一次只允许一个线程访问某个资源，Semaphore(信号量)可以指定多个线程同时访问某个资源。**示例代码如下
 * author:ligz
 */
public class SemaphoreExample1 {
    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
        //创建一个具有固定线程数量的线程池对象
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        //一次只能执行的线程数量
        final Semaphore semaphore = new Semaphore(20);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    semaphore.acquire();//获取一个许可，所以可运行的线程数量为20/1=20
                    test(threadNum);
                    semaphore.release();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum:" + threadNum);
        Thread.sleep(1000);
    }
}
