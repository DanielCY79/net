package com.daniel.concurrentTest;

/**
 * TODO:
 *
 * @author Daniel X
 * @since 2019/8/27 20:17
 */
public class TestDemo {
    static ThreadLocal<String> local1 = new ThreadLocal<>();
    static ThreadLocal<String> local12 = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            local1.set("A1");
            local12.set("A2");
            method();
        }).start();

        new Thread(() -> {
            local1.set("B1");
            local12.set("B2");
            method();
        }).start();
    }

    public static void method() {
        //可以在当前线程的任意地方获取变量
        System.out.println(local1.get() + " " + local12.get());
    }
}
