package com.zhazhapan.demo.algorithm.leetcode.contest.c133;

import org.junit.Test;

public class Contest1029Test {

    @Test
    public void twoCitySchedCost() {
        Contest1029 contest1029 = new Contest1029();
        assert contest1029.twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}) == 110;
        assert contest1029.twoCitySchedCost(new int[][]{{100, 200}, {100, 200}, {100, 200}, {100, 50}}) == 450;
    }
}