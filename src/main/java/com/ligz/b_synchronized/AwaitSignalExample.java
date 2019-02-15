package com.ligz.b_synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * await和signal 的实例
 * author:ligz
 */
public class AwaitSignalExample {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private void before(){
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    private void after(){
        lock.lock();
        try {
            condition.await();
            System.out.println("after");
        }catch (InterruptedException e){
            e.getStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalExample example = new AwaitSignalExample();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());
    }
}
