package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.Arrays;

/**
 * @author pantao
 * @since 2019-03-10
 */
public class Contest1005 {

    @LeetCode(id = 1005, difficulty = Difficulty.EASY, title = "K 次取反后最大化的数组和")
    public int largestSumAfterKNegations(int[] a, int k) {
        Arrays.sort(a);
        int sum = 0;
        int len = a.length;
        for (int i = 0; i < len; ) {
            int val = a[i];
            if (k > 0) {
                if (val >= 0 && k > 1) {
                    k &= 1;
                    continue;
                }
                k--;
                a[i] = -val;
                if (k > 0) {
                    if (i == len - 1) {
                        k &= 1;
                        continue;
                    }
                    if (a[i + 1] > 0) {
                        k &= 1;
                        if (k != 0 && a[i] < a[i + 1]) {
                            continue;
                        }
                    }
                }
            }
            sum += a[i++];
        }
        return sum;
    }
}
