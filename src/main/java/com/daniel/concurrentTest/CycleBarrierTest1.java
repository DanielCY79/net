package com.daniel.concurrentTest;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO:
 *
 * @author Daniel X
 * @since 2019/8/28 14:50
 */
public class CycleBarrierTest1 {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, ()->{
        System.out.println(Thread.currentThread() + " task1 merge result");
    });

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(()->{
            try{
                System.out.println(Thread.currentThread() + " task1-1");
                System.out.println(Thread.currentThread() + " enter in barrier");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread() + " enter out barrier");
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        executorService.submit(()->{
            try{
                System.out.println(Thread.currentThread() + " task1-2");
                System.out.println(Thread.currentThread() + " enter in barrier");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread() + " enter out barrier");
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
