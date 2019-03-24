package com.zhazhapan.demo.algorithm.leetcode.contest;

import org.junit.Test;

public class Contest1022Test {

    @Test
    public void smallestRepunitDivByK() {
        Contest1022 contest1022 = new Contest1022();
        assert 1 == contest1022.smallestRepunitDivByK(1);
        assert -1 == contest1022.smallestRepunitDivByK(2);
        assert 3 == contest1022.smallestRepunitDivByK(3);
        System.out.println(contest1022.smallestRepunitDivByK(7));
        System.out.println(contest1022.smallestRepunitDivByK(9));
        assert 16 == contest1022.smallestRepunitDivByK(17);
    }
}