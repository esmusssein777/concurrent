package com.ligz.b_synchronized;

/**
 * author:ligz
 */
public class JoinExample {
    private class A extends Thread{
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread{
        private A a;

        private B(A a){
            this.a = a;
        }
        @Override
        public void run(){
            try {
                a.join();
            }catch (InterruptedException e){
                e.getStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test(){
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }

    public static void main(String[] args) {
        JoinExample example = new JoinExample();
        example.test();
    }
}
