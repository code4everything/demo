package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import org.junit.Test;

public class Contest1011Test {

    @Test
    public void shipWithinDays() {
        Contest1011 contest1011 = new Contest1011();
        assert 15 == contest1011.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        assert 6 == contest1011.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
        assert 3 == contest1011.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4);
    }
}