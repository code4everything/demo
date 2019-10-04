package org.code4everything.demo.algorithm.leetcode.contest.c133;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

/**
 * @author pantao
 * @since 2019-04-21
 */
public class Contest1029 {

    @LeetCode(id = 1029, difficulty = Difficulty.EASY, title = "两地调度")
    public int twoCitySchedCost(int[][] costs) {
        int len = costs.length / 2;
        return helper(costs, 0, len, len);
    }

    private int helper(int[][] costs, int i, int a, int b) {
        if (i == costs.length) {
            return 0;
        }
        int as = Integer.MAX_VALUE;
        if (a > 0) {
            as = costs[i][0] + helper(costs, i + 1, a - 1, b);
        }
        int bs = Integer.MAX_VALUE;
        if (b > 0) {
            bs = costs[i][1] + helper(costs, i + 1, a, b - 1);
        }
        return Math.min(as, bs);
    }
}
