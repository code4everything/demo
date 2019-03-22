package com.zhazhapan.demo.algorithm.leetcode.dp;

import cn.hutool.core.lang.Console;
import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void maxSubArray() {
        Console.log(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Console.log(solution.maxSubArray(new int[]{-2, 1}));
    }
}