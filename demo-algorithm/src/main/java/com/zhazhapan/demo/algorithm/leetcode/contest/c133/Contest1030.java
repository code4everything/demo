package com.zhazhapan.demo.algorithm.leetcode.contest.c133;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author pantao
 * @since 2019-04-21
 */
public class Contest1030 {

    @LeetCode(id = 1030, title = "距离顺序排列矩阵单元格", difficulty = Difficulty.EASY)
    public int[][] allCellsDistOrder(int r, int c, int r0, int c0) {
        int[][] res = new int[r * c][2];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i * c + j] = new int[]{i, j};
            }
        }
        Arrays.sort(res, Comparator.comparingInt(i -> Math.abs(i[0] - r0) + Math.abs(i[1] - c0)));
        return res;
    }
}
