package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import org.junit.Test;

public class Contest1010Test {

    @Test
    public void numPairsDivisibleBy60() {
        Contest1010 contest1010 = new Contest1010();
        assert 3 == contest1010.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
        assert 3 == contest1010.numPairsDivisibleBy60(new int[]{60, 60, 60});
    }
}