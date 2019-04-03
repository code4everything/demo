package com.zhazhapan.demo.algorithm.leetcode.queue;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

/**
 * @author pantao
 * @since 2019/1/28
 **/
@LeetCode(id = 622, difficulty = Difficulty.MEDIUM, title = "设计循环队列")
public class MyCircularQueue {

    private final int[] queues;

    private final int len;

    private int start = 0;

    private int end = -1;

    private int size = 0;

    public MyCircularQueue(int k) {
        len = k;
        queues = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (size < len) {
            size++;
            if (end == len - 1) {
                end = 0;
            } else {
                end++;
            }
            queues[end] = value;
            return true;
        }
        return false;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (size > 0) {
            if (start == len - 1) {
                start = 0;
            } else {
                start++;
            }
            size--;
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return size > 0 ? queues[start] : -1;
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return size > 0 ? queues[end] : -1;
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size < 1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == len;
    }
}
