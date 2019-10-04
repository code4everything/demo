package org.code4everything.demo.algorithm.leetcode.contest.c130;

import cn.hutool.core.lang.Console;
import org.junit.Test;

public class Contest1018Test {

    @Test
    public void prefixesDivBy5() {
        Contest1018 contest1018 = new Contest1018();
        Console.log(contest1018.prefixesDivBy5(new int[]{0, 1, 1}));
        Console.log(contest1018.prefixesDivBy5(new int[]{1, 1, 1}));
        Console.log(contest1018.prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1}));
        Console.log(contest1018.prefixesDivBy5(new int[]{1, 1, 1, 0, 1}));
        Console.log(contest1018.prefixesDivBy5(new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1}));

    }
}
