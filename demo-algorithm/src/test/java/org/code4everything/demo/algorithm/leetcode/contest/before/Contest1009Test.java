package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.junit.Test;

public class Contest1009Test {

    @Test
    public void bitwiseComplement() {
        Contest1009 contest1009 = new Contest1009();
        assert 2 == contest1009.bitwiseComplement(5);
        assert 0 == contest1009.bitwiseComplement(7);
        assert 5 == contest1009.bitwiseComplement(10);
    }
}
