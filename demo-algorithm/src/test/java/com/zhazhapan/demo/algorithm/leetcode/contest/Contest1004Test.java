package com.zhazhapan.demo.algorithm.leetcode.contest;

import cn.hutool.core.lang.Console;
import org.junit.Test;

public class Contest1004Test {

    @Test
    public void longestOnes() {
        Contest1004 contest1004 = new Contest1004();
        Console.log(contest1004.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        Console.log(contest1004.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}