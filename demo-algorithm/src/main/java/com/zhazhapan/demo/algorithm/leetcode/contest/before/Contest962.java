package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

/**
 * @author pantao
 * @since 2018/12/23
 **/
public class Contest962 {

    @LeetCode(id = 962, difficulty = Difficulty.MEDIUM, title = "最大宽度坡")
    public int maxWidthRamp(int[] a) {
        return maxWidthRamp(a, a.length);
    }

    private int maxWidthRamp(int[] a, int len) {
        if (len < 2) {
            return 0;
        }
        int act = a.length - len;
        for (int i = 0; i <= act; i++) {
            if (a[i] <= a[len - 1 + i]) {
                return len - 1;
            }
        }
        return maxWidthRamp(a, len - 1);
    }

    private int maxWidthRamp(int[] a, int start, int end) {
        if (end > start) {
            if (a[end] >= a[start]) {
                return end - start;
            } else {
                return Math.max(maxWidthRamp(a, start, end - 1), maxWidthRamp(a, start + 1, end));
            }
        }
        return 0;
    }
}
