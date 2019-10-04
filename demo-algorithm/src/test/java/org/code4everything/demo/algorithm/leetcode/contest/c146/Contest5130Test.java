package org.code4everything.demo.algorithm.leetcode.contest.c146;

import org.junit.Test;

public class Contest5130Test {

    @Test
    public void numEquivDominoPairs() {
        Contest5130 contest5130 = new Contest5130();
        assert 1 == contest5130.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}});
        assert 3 == contest5130.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {1, 2}});
        assert 6 == contest5130.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {1, 2}, {2, 1}});
        assert 3 == contest5130.numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}});
    }
}
