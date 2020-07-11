package org.code4everything.demo.algorithm.leetcode.concurrent;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pantao
 * @since 2020/7/11
 */
@LeetCode(id = 1117, title = "H2O 生成", difficulty = Difficulty.MEDIUM)
public class H2O {

    private final Semaphore hydrogenSemaphore = new Semaphore(2);

    private final Semaphore oxygenSemaphore = new Semaphore(1);

    private final AtomicInteger count = new AtomicInteger(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        releaseHydrogen.run();
        releaseSemaphoreIfFull();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        releaseOxygen.run();
        releaseSemaphoreIfFull();
    }

    private void releaseSemaphoreIfFull() {
        if (count.incrementAndGet() % 3 == 0) {
            hydrogenSemaphore.release();
            hydrogenSemaphore.release();
            oxygenSemaphore.release();
        }
    }
}
