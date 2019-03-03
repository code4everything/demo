package com.zhazhapan.demo.algorithm.leetcode.contest;

import cn.hutool.core.lang.Console;
import org.junit.Test;

public class Contest1002Test {

    @Test
    public void commonChars() {
        Contest1002 contest1002 = new Contest1002();
        Console.log(contest1002.commonChars(null));
        Console.log(contest1002.commonChars(new String[]{}));
        Console.log(contest1002.commonChars(new String[]{"bella", "label", "roller"}));
        Console.log(contest1002.commonChars(new String[]{"cool", "lock", "cook"}));
        Console.log(contest1002.commonChars(new String[]{"test"}));
    }
}