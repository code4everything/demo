package com.zhazhapan.demo.algorithm.leetcode.hash;

import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void isHappy() {
        assert !solution.isHappy(2);
        assert solution.isHappy(996655423);
        assert solution.isHappy(19);
    }
}