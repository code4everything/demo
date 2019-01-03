package com.zhazhapan.demo.algorithm.leetcode.binary.search;

import org.junit.Test;

public class SearcherTest {

    @Test
    public void search() {
        Searcher searcher = new Searcher();
        assert 4 == searcher.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        assert -1 == searcher.search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
    }
}
