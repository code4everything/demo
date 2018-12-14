package com.zhazhapan.demo.algorithm.leetcode.tree.binary.search;

import org.junit.Test;

public class KthLargestTest {

    @Test
    public void add() {
        KthLargest largest = new KthLargest(3, new int[]{4, 5, 8, 2});
        assert 4 == largest.add(3);
        assert 5 == largest.add(5);
        assert 5 == largest.add(10);
        assert 8 == largest.add(9);
        assert 8 == largest.add(4);
        largest = new KthLargest(1, new int[0]);
        assert 5 == largest.add(5);
    }
}
