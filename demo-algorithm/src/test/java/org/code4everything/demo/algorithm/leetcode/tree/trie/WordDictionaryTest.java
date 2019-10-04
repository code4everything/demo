package org.code4everything.demo.algorithm.leetcode.tree.trie;

import org.junit.Test;

public class WordDictionaryTest {

    @Test
    public void test() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        assert dictionary.search("bad");
        assert !dictionary.search("pad");
        assert dictionary.search(".ad");
        assert dictionary.search("..d");
        dictionary = new WordDictionary();
        assert !dictionary.search("a");
        dictionary = new WordDictionary();
        dictionary.addWord("a");
        assert !dictionary.search("aa");
        assert !dictionary.search(".a");
        assert !dictionary.search("a.");
    }

    @Test
    public void addWord() {
    }

    @Test
    public void search() {
    }
}
