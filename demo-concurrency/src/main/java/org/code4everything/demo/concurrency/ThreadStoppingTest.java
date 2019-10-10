package org.code4everything.demo.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author pantao
 * @since 2018/12/18
 **/
@SuppressWarnings("all")
public class ThreadStoppingTest {

    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        // stop停止法，需要注意的是stop是个被废弃的方法，使用此方法结束线程是不提倡的
        Thread wayOfStop = new Thread(() -> {
            while (true) {
                printAndSleepSec("thread-stop");
            }
        });
        wayOfStop.start();
        sleepSeconds();
        wayOfStop.stop();

        // interrupt停止方法，同样这并不是一个正确的结束线程的方法，
        // 参考官方文档可知，调用了阻塞线程的方法（如：sleep, wait, join）后，线程的中断信号会被清除
        Thread wayOfInterrupt = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                printAndSleepSec("thread-interrupt");
            }
        });
        wayOfInterrupt.start();
        sleepSeconds();
        // 不能正常中断，因为线程调用了sleep方法
        wayOfInterrupt.interrupt();

        // 标记结束法
        Thread wayOfFlag = new Thread(() -> {
            while (running) {
                printAndSleepSec("thread-flag");
            }
        });
        wayOfFlag.start();
        sleepSeconds();
        running = false;
    }

    private static void sleepSeconds() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }

    private static void printAndSleepSec(String threadName) {
        System.out.println(threadName + " is running");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
