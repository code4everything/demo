package org.code4everything.demo.concurrency;

import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pantao
 * @since 2019/10/10
 */
@SuppressWarnings("NonAtomicOperationOnVolatileField")
public class VolatileTest implements Runnable {

    /**
     * 遍历操作的次数
     */
    private int iterations;

    /**
     * 遍历完成后，latch减一
     */
    private CountDownLatch latch;

    /**
     * 不保证可见性与原子性
     */
    private int plainInt = 0;

    /**
     * 保证可见性，但无法保证原子性
     */
    private volatile int volatileInt = 0;

    /**
     * 只保证原子性，无法保证可见性
     */
    private AtomicInteger atomicInt = new AtomicInteger(0);

    /**
     * 既保证可见性也保证原子性
     */
    private volatile AtomicInteger atomicVolatileInt = new AtomicInteger(0);

    private VolatileTest(int iterations, CountDownLatch latch) {
        this.iterations = iterations;
        this.latch = latch;
    }

    public static void main(String[] args) throws InterruptedException {
        // 线程数
        final int latchCount = 10;
        // CountDownLatch可以看做是允许某个线程执行的阀门，当CountDownLatch==0时，线程从阻塞状态变为运行
        CountDownLatch latch = new CountDownLatch(latchCount);
        // 创建Runnable实例，并新建线程运行他们
        VolatileTest test = new VolatileTest(10_000_000, latch);
        for (int i = 0; i < latchCount; i++) {
            ThreadUtil.execute(test);
        }
        // 阻塞当前线程，等待被唤醒
        latch.await();
        // 打印结果，从结果可以看出plainInt和volatileInt都为脏数据，而atomicInt和atomicVolatileInt均为正确的结果
        // 我的猜测：是不是Atomic本身就保证了原子性呢？
        String msg = "plainInt: {}, volatileInt: {}, atomicInt: {}, atomicVolatileInt: {}";
        Console.log(msg, test.plainInt, test.volatileInt, test.atomicInt.get(), test.atomicVolatileInt.get());
    }

    /**
     * 计算数值
     */
    private void increment() {
        plainInt++;
        volatileInt++;
        atomicInt.getAndIncrement();
        atomicVolatileInt.getAndIncrement();
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            increment();
        }
        latch.countDown();
    }
}
