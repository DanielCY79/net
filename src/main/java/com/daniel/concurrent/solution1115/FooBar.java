package com.daniel.concurrent.solution1115;

import java.util.concurrent.CountDownLatch;

/**
 * TODO:
 *
 * @author Daniel X
 * @since 2019/8/27 14:29
 */
public class FooBar {
    private int n;

    private CountDownLatch countDownLatchA;
    private CountDownLatch countDownLatchB;

    public FooBar(int n) {
        this.n = n;
        countDownLatchA = new CountDownLatch(1);
        countDownLatchB = new CountDownLatch(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            countDownLatchB.await();
            printFoo.run();
            countDownLatchB = new CountDownLatch(1);
            countDownLatchA.countDown();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            countDownLatchA.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            countDownLatchA = new CountDownLatch(1);
            countDownLatchB.countDown();
        }
    }

}
