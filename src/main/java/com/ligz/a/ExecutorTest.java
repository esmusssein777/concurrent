package com.ligz.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 基础线程机制
 * author:ligz
 */
public class ExecutorTest {
    public static void main(String[] args) {
        //Executor 管理多个异步任务的执行，而无需程序员显式地管理线程的生命周期。这里的异步是指多个任务的执行互不干扰，不需要进行同步操作
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++){
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();

        //
        Thread thread = new Thread(new MyRunnable());
        thread.setDaemon(true);
    }

    //非守护线程，主线程结束后子线程继续执行
    public void no_dameon(){
        Thread t = new Thread(new Runnable() {
            public void run() {
                // TODO Auto-generated method stub
                for(int i=1 ; i<=10 ; i++){
                    try {
                        Thread.sleep(500);//线程休眠500毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程执行"+i+"次");
                }
            }
        }) ;
        t.start();
        for(int i=1 ; i<=5 ; i++){
            System.out.println("主线程执行"+i+"次");
        }
    }

    //守护线程，主线程结束后守护线程结束，不在执行。常见的有垃圾回收
    public void dameon(){
        Thread t = new Thread(new Runnable() {
            public void run() {
                // TODO Auto-generated method stub
                for(int i=1 ; i<=10 ; i++){
                    try {
                        Thread.sleep(500);//线程休眠500毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程执行"+i+"次");
                }
            }
        }) ;
        t.start();
        for(int i=1 ; i<=5 ; i++){
            System.out.println("主线程执行"+i+"次");
        }
    }
}
