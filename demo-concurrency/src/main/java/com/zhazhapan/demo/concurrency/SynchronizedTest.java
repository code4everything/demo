package com.zhazhapan.demo.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author pantao
 * @since 2019-02-16
 */
public class SynchronizedTest extends Thread {

    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest test1 = new SynchronizedTest();
        SynchronizedTest test2 = new SynchronizedTest();
        test1.start();
        test2.start();
        TimeUnit.SECONDS.sleep(1);
        test1.interrupt();
        test2.interrupt();
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
