package com.zhazhapan.demo.algorithm.leetcode.design;

import java.util.Random;

/**
 * @author pantao
 * @since 2019-03-23
 */
public class Solution {

    private int[] nums;

    private int len;

    private int[] idxs;

    private Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        len = nums.length;
        idxs = new int[len];
        for (int i = 0; i < len; i++) {
            idxs[i] = i;
        }
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] idxs = this.idxs.clone();
        int[] tmp = new int[len];
        int bound = len;
        for (int i = 0; i < len; i++) {
            int idx = random.nextInt(bound);
            tmp[idxs[idx]] = nums[i];
            idxs[idx] = idxs[--bound];
        }
        return tmp;
    }
}
