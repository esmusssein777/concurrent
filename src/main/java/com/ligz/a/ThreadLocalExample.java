package com.ligz.a;

/**
 * 线程本地存储
 * author:ligz
 * 果能保证，我们就可以把共享数据的可见范围限制在同一个线程之内，这样，无须同步也能保证线程之间不出现数据争用的问题
 */
public class ThreadLocalExample {
    /**
     * thread1 中设置 threadLocal 为 1，而 thread2 设置 threadLocal 为 2。过了一段时间之后，thread1 读取 threadLocal 依然是 1，不受 thread2 的影响
     */
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
           threadLocal.set(1);
           try {
               Thread.sleep(1000);
           }catch (InterruptedException e){
               e.getStackTrace();
           }
           System.out.println(threadLocal.get());
           threadLocal.remove();
        });
        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            threadLocal.remove();
        });
        thread1.start();
        thread2.start();
    }
}
