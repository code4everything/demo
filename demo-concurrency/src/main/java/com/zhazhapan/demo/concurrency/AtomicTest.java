package com.zhazhapan.demo.concurrency;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 可见性测试
 *
 * @author pantao
 * @since 2019/9/4
 */
public class AtomicTest {

    private static volatile AtomicInteger ADDABLE = new AtomicInteger();

    private static volatile AtomicBoolean RUNNING = new AtomicBoolean(true);

    public static void main(String[] args) {
        ThreadUtil.execute(() -> {
            while (RUNNING.get()) {
                System.out.println(Thread.currentThread().getName() + " >>> " + ADDABLE.incrementAndGet());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        ThreadUtil.execute(() -> {
            while (ADDABLE.get() != 3) {
                System.out.println(Thread.currentThread().getName() + " >>> " + ADDABLE.get());
            }
            RUNNING.set(false);
        });
    }
}
