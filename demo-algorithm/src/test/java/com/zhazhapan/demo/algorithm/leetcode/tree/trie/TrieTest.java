package com.zhazhapan.demo.algorithm.leetcode.tree.trie;

import org.junit.Test;

public class TrieTest {

    @Test
    public void test() {
        int testTimes = 1000;
        long mapSum = 0;
        for (int i = 0; i < testTimes; i++) {
            long start = System.currentTimeMillis();
            testOperation(new MapTrie());
            mapSum += System.currentTimeMillis() - start;
        }
        long arraySum = 0;
        for (int i = 0; i < testTimes; i++) {
            long start = System.currentTimeMillis();
            testOperation(new ArrayTrie());
            arraySum += System.currentTimeMillis() - start;
        }
        System.out.println("map use time -> " + mapSum);
        System.out.println("array use time -> " + arraySum);
        // 从测试结果可以看出：数组实现的前缀树效率更高，但是需要占用更多的空间，灵活性较小
    }

    public void testOperation(Trie trie) {
        trie.insert("apple");
        assert trie.search("apple");
        assert !trie.search("app");
        assert trie.startsWith("app");
        trie.insert("app");
        trie.insert("window");
        trie.insert("lamb");
        trie.insert("condition");
        assert trie.search("app");
        assert trie.startsWith("");
    }

    @Test
    public void insert() {

    }

    @Test
    public void search() {
    }

    @Test
    public void startsWith() {
    }
}
