package com.zhazhapan.demo.algorithm.leetcode.contest.c130;

import cn.hutool.core.lang.Console;
import org.junit.Test;

public class Contest1029Test {

    @Test
    public void prefixesDivBy5() {
        Contest1029 contest1029 = new Contest1029();
        Console.log(contest1029.prefixesDivBy5(new int[]{0, 1, 1}));
        Console.log(contest1029.prefixesDivBy5(new int[]{1, 1, 1}));
        Console.log(contest1029.prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1}));
        Console.log(contest1029.prefixesDivBy5(new int[]{1, 1, 1, 0, 1}));
        Console.log(contest1029.prefixesDivBy5(new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1}));

    }
}