package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.junit.Test;

public class Contest961Test {

    @Test
    public void repeatedNTimes() {
        Contest961 contest961 = new Contest961();
        assert 3 == contest961.repeatedNTimes(new int[]{3, 1, 2, 3});
        assert 3 == contest961.repeatedNTimes(new int[]{3, 1, 3, 2});
    }
}
