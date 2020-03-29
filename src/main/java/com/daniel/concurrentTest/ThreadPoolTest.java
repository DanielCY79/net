package com.daniel.concurrentTest;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO:
 *
 * @author Daniel X
 * @since 2019/8/27 19:44
 */
public class ThreadPoolTest {
    static class LocalVariable {
        private Long[] a = new Long[1024 * 1024];

    }

    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
    final static ThreadLocal<LocalVariable> localVariable = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 50; ++i) {
            poolExecutor.execute(() -> {
                localVariable.set(new LocalVariable());
                System.out.println("use local variable");
            });

            Thread.sleep(1);
        }

        System.out.println("pool executor over");
    }
}
