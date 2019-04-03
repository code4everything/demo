package com.zhazhapan.demo.algorithm.leetcode.tree.binary.search;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author pantao
 * @since 2018/12/14
 **/
@LeetCode(id = 703, difficulty = Difficulty.EASY, title = "数据流中的第K大元素")
public class KthLargest {

    private Queue<Integer> heap;

    private int maxSize;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>(k);
        maxSize = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (heap.isEmpty() || heap.size() < maxSize) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}
