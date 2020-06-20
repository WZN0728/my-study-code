package com.thread;

/**
 * @author wuting
 * @date 2019/06/21
 */
public class ThreadTest {

    public static void main(String[] args) {
        threadLocalDemo();
    }

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public static void threadLocalDemo() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        threadLocal.set(i);
                        System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    threadLocal.remove();
                }
            }
        }, "threadLocal1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    threadLocal.remove();
                }
            }
        }, "threadLocal2").start();

    }

}
