package com.zhazhapan.demo.algorithm.leetcode.design;

import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        assert 1 == cache.get(1);
        cache.put(3, 3);
        assert -1 == cache.get(2);
        cache.put(4, 4);
        assert -1 == cache.get(1);
        assert 3 == cache.get(3);
        assert 4 == cache.get(4);
    }
}