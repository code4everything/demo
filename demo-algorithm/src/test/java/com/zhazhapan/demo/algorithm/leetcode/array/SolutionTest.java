package com.zhazhapan.demo.algorithm.leetcode.array;

import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void pivotIndex() {
        assert solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}) == 3;
        assert solution.pivotIndex(new int[]{1, 2, 3}) == -1;
        assert solution.pivotIndex(new int[]{3, 0}) == 0;
        assert solution.pivotIndex(new int[]{0, 1}) == 1;
        assert solution.pivotIndex(new int[]{-1, -1, 1, 1, 0, 0}) == 4;
    }
}
