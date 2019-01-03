package com.zhazhapan.demo.algorithm.leetcode.binary.search;

import org.junit.Test;

public class SearcherTest {

    @Test
    public void search() {
        Searcher searcher = new Searcher();
        assert 4 == searcher.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        assert -1 == searcher.search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
    }

    @Test
    public void mySqrt() {
        Searcher searcher = new Searcher();
        assert 0 == searcher.mySqrt(0);
        assert 1 == searcher.mySqrt(1);
        assert 1 == searcher.mySqrt(2);
        assert 2 == searcher.mySqrt(4);
        assert 4 == searcher.mySqrt(16);
        assert 4 == searcher.mySqrt(24);
        assert 6 == searcher.mySqrt(36);
        assert searcher.mySqrt(2147395599) == 46339;
    }
}
