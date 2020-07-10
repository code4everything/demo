package org.code4everything.demo.algorithm.leetcode.concurrent;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class FooTest {

    @Test
    public void test() throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        CountDownLatch latch = new CountDownLatch(3);
        ThreadUtil.execute(() -> {
            new Foo().first(() -> sb.append("1"));
            latch.countDown();
        });
        ThreadUtil.execute(() -> {
            try {
                new Foo().second(() -> sb.append("2"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });
        ThreadUtil.execute(() -> {
            try {
                new Foo().third(() -> sb.append("3"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });
        latch.await();
        System.out.println(sb.toString());
    }
}
