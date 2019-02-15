package com.ligz.a;

/**
 * author:ligz
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
