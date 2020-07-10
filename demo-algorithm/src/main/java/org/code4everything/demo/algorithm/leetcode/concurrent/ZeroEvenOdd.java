package org.code4everything.demo.algorithm.leetcode.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntConsumer;

/**
 * @author pantao
 * @since 2020/7/10
 */
public class ZeroEvenOdd {

    private final Object lock = new Object();

    private final AtomicBoolean eventNotOk = new AtomicBoolean(true);

    private int n;

    private int i = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {}

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            eventNotOk.set(false);
            for (; i < n; ) {
                lock.wait();
                printNumber.accept(++i);
                lock.notify();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (eventNotOk.get()) {}
        synchronized (lock) {
            for (; i < n; ) {
                printNumber.accept(++i);
                lock.notify();
                lock.wait();
            }
        }
    }
}
