package org.code4everything.demo.algorithm.leetcode.contest.before;

import cn.hutool.core.lang.Console;
import org.junit.Test;

public class Contest985Test {

    @Test
    public void test() {
        Contest985 contest985 = new Contest985();
        Console.log(contest985.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2,
                3}}));
    }
}
