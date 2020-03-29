package com.daniel.concurrentTest;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO:
 *
 * @author Daniel X
 * @since 2019/8/28 14:55
 */
public class CycleBarrierTest2 {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread() + " step 1");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread() + " step 2");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread() + " step 3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread() + " step 1");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread() + " step 2");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread() + " step 3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
