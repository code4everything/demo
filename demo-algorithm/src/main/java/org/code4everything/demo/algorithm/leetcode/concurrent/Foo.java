package org.code4everything.demo.algorithm.leetcode.concurrent;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pantao
 * @since 2020/7/10
 */
@LeetCode(id = 1114, title = "按序打印", difficulty = Difficulty.EASY)
public class Foo {

    private final AtomicInteger integer = new AtomicInteger(0);

    public void first(Runnable printFirst) {
        printFirst.run();
        integer.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (integer.get() < 1) {
        }
        printSecond.run();
        integer.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (integer.get() < 2) {
        }
        printThird.run();
    }
}
