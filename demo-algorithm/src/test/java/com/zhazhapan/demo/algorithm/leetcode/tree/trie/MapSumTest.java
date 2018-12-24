package com.zhazhapan.demo.algorithm.leetcode.tree.trie;

import org.junit.Test;

public class MapSumTest {

    @Test
    public void test() {
        MapSum sum = new MapSum();
        sum.insert("apple", 3);
        assert 3 == sum.sum("app");
        assert 0 == sum.sum("l");
        sum.insert("app", 2);
        assert 5 == sum.sum("app");
    }

    @Test
    public void insert() {

    }

    @Test
    public void sum() {
    }
}
