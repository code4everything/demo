package org.code4everything.demo.algorithm.leetcode.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pantao
 * @since 2020/7/11
 */
public class DiningPhilosophers {

    /**
     * 1个Fork视为1个ReentrantLock，5个叉子即5个ReentrantLock，将其都放入数组中
     */
    private final ReentrantLock[] lockList = {new ReentrantLock(), new ReentrantLock(), new ReentrantLock(),
            new ReentrantLock(), new ReentrantLock()};

    /**
     * 限制 最多只有4个哲学家去持有叉子
     */
    private Semaphore eatLimit = new Semaphore(4);

    public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
                           Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {

        //左边的叉子 的编号
        int leftFork = (philosopher + 1) % 5;
        //右边的叉子 的编号
        int rightFork = philosopher;

        //限制的人数 -1
        eatLimit.acquire();

        //拿起左边的叉子
        lockList[leftFork].lock();
        //拿起右边的叉子
        lockList[rightFork].lock();

        //拿起左边的叉子 的具体执行
        pickLeftFork.run();
        //拿起右边的叉子 的具体执行
        pickRightFork.run();

        //吃意大利面 的具体执行
        eat.run();

        //放下左边的叉子 的具体执行
        putLeftFork.run();
        //放下右边的叉子 的具体执行
        putRightFork.run();

        //放下左边的叉子
        lockList[leftFork].unlock();
        //放下右边的叉子
        lockList[rightFork].unlock();

        //限制的人数 +1
        eatLimit.release();
    }
}
