package org.code4everything.demo.algorithm.leetcode.concurrent;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author pantao
 * @since 2020/7/11
 */
@LeetCode(id = 1195, title = "交替打印字符串", difficulty = Difficulty.MEDIUM)
public class FizzBuzz {

    private final AtomicBoolean running = new AtomicBoolean(true);

    private final AtomicBoolean fizzBarrier = new AtomicBoolean(false);

    private final AtomicBoolean buzzBarrier = new AtomicBoolean(false);

    private final AtomicBoolean fizzBuzzBarrier = new AtomicBoolean(false);

    private final AtomicInteger integer = new AtomicInteger(0);

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (running.get()) {
            if (fizzBarrier.get()) {
                printFizz.run();
                fizzBarrier.set(false);
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (running.get()) {
            if (buzzBarrier.get()) {
                printBuzz.run();
                buzzBarrier.set(false);
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (running.get()) {
            if (fizzBuzzBarrier.get()) {
                printFizzBuzz.run();
                fizzBuzzBarrier.set(false);
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (running.get()) {
            while (fizzBarrier.get() || fizzBuzzBarrier.get() || buzzBarrier.get()) {}
            int i = integer.incrementAndGet();
            if (i > n) {
                running.set(false);
                break;
            }
            boolean threeDivided = i % 3 == 0;
            boolean fiveDivided = i % 5 == 0;
            if (threeDivided && fiveDivided) {
                fizzBuzzBarrier.set(true);
            } else if (threeDivided) {
                fizzBarrier.set(true);
            } else if (fiveDivided) {
                buzzBarrier.set(true);
            } else {
                printNumber.accept(i);
            }
        }
    }
}
