package com.daniel.concurrent.solution1115;


/**
 * TODO:
 *
 * @author Daniel X
 * @since 2019/8/27 14:29
 */
public class FooBar2 {
    private int n;

    private final Object lock = new Object();

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock){
                if(i == 0){
                    lock.wait(1);
                }else{
                    lock.wait();
                }

                printFoo.run();
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock){
                lock.wait();
                printBar.run();
                lock.notifyAll();
            }

        }
    }

//    public static void main(String[] args) {
//        FooBar2 fooBar = new FooBar2(10);
//        Thread t1 = new Thread(()->{
//            try {
//                fooBar.foo();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        Thread t2 = new Thread(()->{
//            try {
//                fooBar.bar();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        t1.start();
//        t2.start();
//    }
}
