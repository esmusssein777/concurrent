package com.ligz.a;

/**
 * author:ligz
 */
public class MyThread extends Thread{
    public void run(){
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        }catch (InterruptedException exception){
            exception.getStackTrace();
        }
        System.out.println(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
