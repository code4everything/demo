package com.zhazhapan.demo.algorithm.leetcode.contest.c141;

import org.junit.Test;

public class Contest1090Test {

    @Test
    public void largestValsFromLabels() {
        Contest1090 contest1090 = new Contest1090();
        assert 9 == contest1090.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3}, 3, 1);
        assert 12 == contest1090.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 3, 3, 3, 2}, 3, 2);
        assert 16 == contest1090.largestValsFromLabels(new int[]{9, 8, 8, 7, 6}, new int[]{0, 0, 0, 1, 1}, 3, 1);
        assert 24 == contest1090.largestValsFromLabels(new int[]{9, 8, 8, 7, 6}, new int[]{0, 0, 0, 1, 1}, 3, 2);
    }
}