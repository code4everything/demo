package org.code4everything.demo.algorithm.leetcode.concurrent;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

public class ZeroEvenOddTest {

    @Test
    public void test() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        StringBuffer sb = new StringBuffer();
        IntConsumer intConsumer = value -> sb.append(StrUtil.padPre(String.valueOf(value), 2, "0"));
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(13);
        ThreadUtil.execute(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });
        ThreadUtil.execute(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });
        latch.await();
        System.out.println(sb.toString());
    }
}
