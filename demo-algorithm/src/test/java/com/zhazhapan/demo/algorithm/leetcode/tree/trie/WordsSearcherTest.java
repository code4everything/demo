package com.zhazhapan.demo.algorithm.leetcode.tree.trie;

import org.junit.Test;

public class WordsSearcherTest {

    @Test
    public void findWords() {
        WordsSearcher searcher = new WordsSearcher();
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f',
                'l', 'v'}};
        System.out.println(searcher.findWords(board, new String[]{"oath", "pea", "eat", "rain"}));
        System.out.println(searcher.findWords(new char[][]{{'a', 'a'}}, new String[]{"aaa"}));
        System.out.println(searcher.findWords(new char[][]{{'a', 'b'}, {'a', 'a'}}, new String[]{"aba", "baa", "bab",
                "aaab", "aaa", "aaaa", "aaba"}));
    }
}
