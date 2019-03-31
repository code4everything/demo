package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.contest.before.Contest994;
import org.junit.Test;

public class Contest994Test {

    @Test
    public void orangesRotting() {
        Contest994 contest994 = new Contest994();
        assert 4 == contest994.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
        assert -1 == contest994.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}});
        assert 0 == contest994.orangesRotting(new int[][]{{0, 2}});
    }
}