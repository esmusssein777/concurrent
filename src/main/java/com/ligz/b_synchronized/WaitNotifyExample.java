package com.ligz.b_synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * wait和 notify的实例
 * author:ligz
 */
public class WaitNotifyExample {
    public synchronized void before(){
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after(){
        try {
            wait();
        }catch (InterruptedException e){
            e.getStackTrace();
        }
        System.out.println("after notify");
    }

    public static void main(String[] args) {
        WaitNotifyExample example = new WaitNotifyExample();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> example.after());
        service.execute(() -> example.before());
    }
}
