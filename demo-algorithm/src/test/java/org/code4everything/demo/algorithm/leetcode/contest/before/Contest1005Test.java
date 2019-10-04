package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.junit.Test;

public class Contest1005Test {

    @Test
    public void largestSumAfterKNegations() {
        Contest1005 contest1005 = new Contest1005();
        assert 5 == contest1005.largestSumAfterKNegations(new int[]{4, 2, 3}, 1);
        assert 6 == contest1005.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3);
        assert 13 == contest1005.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2);
        assert 13 == contest1005.largestSumAfterKNegations(new int[]{-12, -2, -1}, 4);
        assert 26 == contest1005.largestSumAfterKNegations(new int[]{1, 3, 2, 6, 7, 9}, 3);
        assert 22 == contest1005.largestSumAfterKNegations(new int[]{-8, 3, -5, -3, -5, -2}, 6);
    }
}
