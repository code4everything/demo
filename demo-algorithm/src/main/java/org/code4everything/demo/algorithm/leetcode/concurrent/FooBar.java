package org.code4everything.demo.algorithm.leetcode.concurrent;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author pantao
 * @since 2020/7/10
 */
@LeetCode(id = 1115, title = "交替打印FooBar", difficulty = Difficulty.MEDIUM)
public class FooBar {

    private final Object lock = new Object();

    private final AtomicBoolean fooNotOk = new AtomicBoolean(true);

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        while (fooNotOk.get()) {}
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                printFoo.run();
                lock.notify();
                lock.wait();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (lock) {
            fooNotOk.set(false);
            for (int i = 0; i < n; i++) {
                lock.wait();
                printBar.run();
                lock.notify();
            }
        }
    }

    /**
     * 原子类实现方案，运行超时了Q_Q
     */
    public static class AtomicFooBar {

        private final AtomicBoolean isBarWorking = new AtomicBoolean(false);

        private int n;

        public AtomicFooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (isBarWorking.get()) {}
                printFoo.run();
                isBarWorking.set(true);
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (!isBarWorking.get()) {}
                printBar.run();
                isBarWorking.set(false);
            }
        }
    }
}
