package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.contest.before.Contest1014;
import org.junit.Test;

public class Contest1014Test {

    @Test
    public void shipWithinDays() {
        Contest1014 contest1014 = new Contest1014();
        assert 15 == contest1014.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        assert 6 == contest1014.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
        assert 3 == contest1014.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4);
    }
}