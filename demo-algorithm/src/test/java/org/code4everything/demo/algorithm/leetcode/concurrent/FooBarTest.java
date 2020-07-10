package org.code4everything.demo.algorithm.leetcode.concurrent;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class FooBarTest {

    @Test
    public void test() throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        FooBar fooBar = new FooBar(3);
        CountDownLatch latch = new CountDownLatch(2);
        ThreadUtil.execute(() -> {
            try {
                fooBar.foo(() -> sb.append("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });
        ThreadUtil.execute(() -> {
            try {
                fooBar.bar(() -> sb.append("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });
        latch.await();
        System.out.println(sb.toString());
    }
}
