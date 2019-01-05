package com.zhazhapan.demo.algorithm.leetcode.binary.search;

/**
 * @author pantao
 * @since 2019-01-03
 */
public class Searcher {

    public int search2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            long target = 0;
            int left = 1;
            int right = x / 2;
            while (left <= right) {
                target = (left + right) / 2;
                long sqrt = target * target;
                if (sqrt == x) {
                    break;
                } else if (sqrt > x) {
                    right = (int) target - 1;
                } else if ((target + 1) * (target + 1) > x) {
                    break;
                } else {
                    left = (int) (target + 1);
                }
            }
            return (int) target;
        }
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int idx = (start + end) / 2;
            int num = nums[idx];
            if (num == target) {
                return idx;
            } else if (num > target) {
                end = idx - 1;
            } else {
                start = idx + 1;
            }
        }
        return -1;
    }
}
