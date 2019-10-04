package org.code4everything.demo.concurrency;

import cn.hutool.core.thread.ThreadUtil;

/**
 * @author pantao
 * @since 2019-02-16
 */
public class WaitAndNotifyTest {

    private static final Object LOCK = new Object();

    private static final int THRESHOLD = 100;

    private static int count = 0;

    public static void main(String[] args) {
        // 两个线程依次打印：1,2,3,4,5.....
        ThreadUtil.execute(WaitAndNotifyTest::print);
        ThreadUtil.execute(WaitAndNotifyTest::print);
    }

    private static void print() {
        synchronized (LOCK) {
            while (count < THRESHOLD) {
                System.out.println("Thread-" + Thread.currentThread().getId() + " >>> " + (++count));
                LOCK.notify();
                try {
                    LOCK.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
