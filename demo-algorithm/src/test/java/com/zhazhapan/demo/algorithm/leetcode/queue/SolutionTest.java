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

    @Test
    public void openLock() {
        assert solution.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202") == 6;
        assert solution.openLock(new String[]{"8888"}, "0009") == 1;
        assert solution.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"},
                                 "8888") == -1;
        assert solution.openLock(new String[]{"0000"}, "8888") == -1;
    }

    @Test
    public void numSquares() {
        assert solution.numSquares(12) == 3;
        assert solution.numSquares(13) == 2;
        assert solution.numSquares(30) == 3;
        assert solution.numSquares(3) == 3;
        assert solution.numSquares(2) == 2;
        assert solution.numSquares(191) == 4;
    }

    @Test
    public void calculate() {
        assert solution.calculate("3+2*2") == 7;
        assert solution.calculate(" 3/2 ") == 1;
        assert solution.calculate(" 3+5 / 2 ") == 5;
        assert solution.calculate("2*3*4") == 24;
    }
}
