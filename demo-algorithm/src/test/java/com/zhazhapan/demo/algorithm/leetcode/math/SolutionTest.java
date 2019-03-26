package com.zhazhapan.demo.algorithm.leetcode.math;

import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void isPowerOfThree() {
        assert !solution.isPowerOfThree(0);
        assert solution.isPowerOfThree(3);
        assert !solution.isPowerOfThree(45);
        assert solution.isPowerOfThree(1);
        assert !solution.isPowerOfThree(2147483647);
    }
}