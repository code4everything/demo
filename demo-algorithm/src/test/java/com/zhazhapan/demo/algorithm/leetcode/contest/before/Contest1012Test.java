package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.contest.before.Contest1012;
import org.junit.Test;

public class Contest1012Test {

    @Test
    public void bitwiseComplement() {
        Contest1012 contest1012 = new Contest1012();
        assert 2 == contest1012.bitwiseComplement(5);
        assert 0 == contest1012.bitwiseComplement(7);
        assert 5 == contest1012.bitwiseComplement(10);
    }
}