package com.zhazhapan.demo.algorithm.leetcode.design;

import cn.hutool.core.lang.Console;
import org.junit.Test;

public class AllOneTest {

    @Test
    public void test() {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("c");
        Console.log(allOne.getMaxKey());
        Console.log(allOne.getMinKey());
        allOne.inc("a");
        Console.log(allOne.getMaxKey());
        allOne.inc("b");
        allOne.inc("b");
        Console.log(allOne.getMaxKey());
        Console.log(allOne.getMinKey());
        allOne.dec("c");
        Console.log(allOne.getMinKey());
    }
}