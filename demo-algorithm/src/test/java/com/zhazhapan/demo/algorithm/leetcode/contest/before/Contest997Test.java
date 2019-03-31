package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.contest.before.Contest997;
import org.junit.Test;

public class Contest997Test {

    @Test
    public void findJudge() {
        Contest997 contest997 = new Contest997();
        assert 2 == contest997.findJudge(2, new int[][]{{1, 2}});
        assert 3 == contest997.findJudge(3, new int[][]{{1, 3}, {2, 3}});
        assert -1 == contest997.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}});
        assert 3 == contest997.findJudge(4, new int[][]{{1, 2}, {1, 3}, {2, 1}, {2, 3}, {1, 4}, {4, 3}, {4, 1}});
        assert 1 == contest997.findJudge(2, new int[][]{{2, 1}});
    }
}