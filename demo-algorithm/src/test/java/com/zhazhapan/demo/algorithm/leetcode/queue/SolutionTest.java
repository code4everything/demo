package com.zhazhapan.demo.algorithm.leetcode.queue;

import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void numIslands() {
        assert solution.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0',
                '0', '0'}, {'0', '0', '0', '0', '0'}}) == 1;
        assert solution.numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1',
                '0', '0'}, {'0', '0', '0', '1', '1'}}) == 3;
    }
}
