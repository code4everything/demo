package com.zhazhapan.demo.algorithm.leetcode.tree.trie;

import org.junit.Test;

import java.util.Arrays;

public class WordsReplacerTest {

    @Test
    public void replaceWords() {
        WordsReplacer replacer = new WordsReplacer();
        System.out.println(replacer.replaceWords(Arrays.asList("cat", "bat", "rat"),
                "the cattle was rattled by the " + "battery"));
    }
}
