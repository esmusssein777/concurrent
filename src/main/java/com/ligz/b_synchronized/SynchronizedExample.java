package com.ligz.b_synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 同步一个代码块
 * author:ligz
 */
public class SynchronizedExample {
    public void func1(){
        synchronized (this){
            for (int i = 0; i < 10; i++){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        /*SynchronizedExample s1 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> s1.func1());
        executorService.execute(() -> s1.func1());
        executorService.shutdown();*/

        ExecutorService executorService2 = Executors.newCachedThreadPool();
        SynchronizedExample s2 = new SynchronizedExample();
        SynchronizedExample s3 = new SynchronizedExample();
        executorService2.execute(() -> s2.func1());
        executorService2.execute(() -> s3.func1());
    }
}
