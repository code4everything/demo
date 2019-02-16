package com.zhazhapan.demo.concurrency;

import cn.hutool.core.thread.ThreadUtil;

/**
 * @author pantao
 * @since 2019-02-16
 */
public class WaitAndNotifyTest {

    private static final Object lock = new Object();

    private static int count = 0;

    public static void main(String[] args) {
        ThreadUtil.execute(WaitAndNotifyTest::print);
        ThreadUtil.execute(WaitAndNotifyTest::print);
    }

    private static void print() {
        synchronized (lock) {
            while (count < 100) {
                System.out.println("Thread-" + Thread.currentThread().getId() + " >>> " + (++count));
                lock.notify();
                try {
                    lock.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
