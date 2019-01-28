package com.zhazhapan.demo.algorithm.leetcode.queue;

import org.junit.Test;

public class MyCircularQueueTest {

    @Test
    public void test() {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为3
        assert circularQueue.enQueue(1);  // 返回true
        assert circularQueue.enQueue(2);  // 返回true
        assert circularQueue.enQueue(3);  // 返回true
        assert !circularQueue.enQueue(4);  // 返回false,队列已满
        assert 3 == circularQueue.Rear();  // 返回3
        assert circularQueue.isFull();  // 返回true
        assert circularQueue.deQueue();  // 返回true
        assert circularQueue.enQueue(4);  // 返回true
        assert 4 == circularQueue.Rear();  // 返回4
    }
}
