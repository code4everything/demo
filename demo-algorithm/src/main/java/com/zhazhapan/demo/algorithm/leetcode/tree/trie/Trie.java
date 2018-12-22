package com.zhazhapan.demo.algorithm.leetcode.tree.trie;

/**
 * @author pantao
 * @since 2018-12-22
 */
public interface Trie {


    void insert(String word);

    boolean search(String word);

    boolean startsWith(String prefix);
}
