package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.junit.Test;

public class Contest1006Test {

    @Test
    public void clumsy() throws Exception {
        Contest1006 contest1006 = new Contest1006();
        //        assert 7 == contest1006.clumsy(4);
        System.out.println(contest1006.clumsy(10));
        assert 12 == contest1006.clumsy(10);
    }
}
