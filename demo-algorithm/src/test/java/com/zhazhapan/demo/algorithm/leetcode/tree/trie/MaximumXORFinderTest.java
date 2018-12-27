package com.zhazhapan.demo.algorithm.leetcode.tree.trie;

import org.junit.Test;

public class MaximumXORFinderTest {

    @Test
    public void test() {
        System.out.println(1 << 2);
    }

    @Test
    public void findMaximumXOR() {
        MaximumXORFinder finder = new MaximumXORFinder();
        System.out.println(finder.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }
}
