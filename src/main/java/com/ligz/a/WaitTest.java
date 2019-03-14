package com.ligz.a;

/**
 * author:ligz
 */
public class WaitTest {
    public boolean flag;

    public class OddClass implements Runnable{
        private WaitTest w;

        public OddClass(WaitTest w) {
            this.w = w;
        }

        @Override
        public void run() {
            int i = 1;
            while (i < 100) {
                synchronized (w) {
                    if (!w.flag) {
                        System.out.println(i);
                        i += 2;
                        w.flag = true;
                        w.notify();
                    }else {
                        try {
                            w.wait();
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public class EvenClass implements Runnable{
        private WaitTest w;

        public EvenClass(WaitTest w) {
            this.w = w;
        }

        @Override
        public void run() {
            int i = 2;
            while (i <= 100) {
                synchronized (w) {
                    if (w.flag) {
                        System.out.println(i);
                        i += 2;
                        w.flag = false;
                        w.notify();
                    } else {
                        try {
                            w.wait();
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        WaitTest waitTest = new WaitTest();
        OddClass oddClass = waitTest.new OddClass(waitTest);
        EvenClass evenClass = waitTest.new EvenClass(waitTest);
        new Thread(oddClass).start();
        new Thread(evenClass).start();
    }
}
