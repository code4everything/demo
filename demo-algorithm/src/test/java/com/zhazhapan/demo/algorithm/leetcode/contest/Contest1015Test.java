package com.zhazhapan.demo.algorithm.leetcode.contest;

import org.junit.Test;

public class Contest1015Test {

    @Test
    public void numDupDigitsAtMostN() {
        Contest1015 contest1015 = new Contest1015();
        assert 1 == contest1015.numDupDigitsAtMostN(20);
        assert 10 == contest1015.numDupDigitsAtMostN(100);
        assert 262 == contest1015.numDupDigitsAtMostN(1000);
        System.out.println(contest1015.numDupDigitsAtMostN(31034990));
    }
}