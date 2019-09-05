package com.zhazhapan.demo.concurrency;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author pantao
 * @since 2019-02-16
 */
public class SynchronizedTest extends Thread {

    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        //        SynchronizedTest test1 = new SynchronizedTest();
        //        SynchronizedTest test2 = new SynchronizedTest();
        //        test1.start();
        //        test2.start();
        //        TimeUnit.SECONDS.sleep(1);
        //        test1.interrupt();
        //        test2.interrupt();

        System.out.println();
        ThreadUtil.execute(() -> {
            try {
                SynchronizedTest.classSync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        TimeUnit.SECONDS.sleep(1);
        ThreadUtil.execute(SynchronizedTest::objectSync);
    }

    private static void objectSync() {
        synchronized (new SynchronizedTest()) {
            System.out.println("object sync exit");
        }
    }

    private static void classSync() throws InterruptedException {
        synchronized (SynchronizedTest.class) {
            System.out.println("class syncing");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("class sync exit");
        }
    }

    private synchronized void add() {
        count++;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            add();
            System.out.println("Thread " + Thread.currentThread().getId() + " >>> " + count);
        }
    }
}
