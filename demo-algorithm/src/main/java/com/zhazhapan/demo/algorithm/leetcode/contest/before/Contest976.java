package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.Arrays;

/**
 * @author pantao
 * @since 2019-01-13
 */
public class Contest976 {

    @LeetCode(id = 76, difficulty = Difficulty.EASY, title = "三角形的最大周长")
    public int largestPerimeter(int[] a) {
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (a[i] + a[j] > a[k] && a[i] - a[j] < a[k]) {
                        return a[i] + a[j] + a[k];
                    }
                }
            }
        }
        return 0;
    }
}
