package org.code4everything.demo.concurrency;

import cn.hutool.core.lang.Console;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试Lock的可见性
 *
 * @author pantao
 * @since 2019/10/10
 */
@SuppressWarnings("all")
public class LockTest implements Runnable {

    private final Lock lock = new ReentrantLock();

    private int iterations;

    private int plainInt = 0;

    private LockTest(int iterations) {
        this.iterations = iterations;
    }

    public static void main(String[] args) throws InterruptedException {
        // 新建Runnable实例
        LockTest test = new LockTest(1_000_000);
        // 创建线程
        Thread threadOne = new Thread(test);
        Thread threadTwo = new Thread(test);
        // 启动线程
        threadOne.start();
        threadTwo.start();
        // 阻塞当前线程，并等待工作线程的完成
        threadOne.join();
        threadTwo.join();

        // 从测试结果中可以看出，Lock同样保证了共享变量的可见性
        Console.log("plainInt: {}", test.plainInt);
    }

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < iterations; i++) {
                plainInt++;
            }
        } finally {
            lock.unlock();
        }
    }
}
