package com.zhazhapan.demo.concurrency;

/**
 * @author pantao
 * @since 2018/12/18
 **/
public class ThreadInterruptTest extends Thread {

    public static void main(String[] args) {
        ThreadInterruptTest interruptTest = new ThreadInterruptTest();
        interruptTest.start();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("test");
            Thread.currentThread().interrupt();
        }
    }
}
