package com.zhazhapan.demo.algorithm.leetcode.tree.trie;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

/**
 * @author pantao
 * @since 2018-12-22
 */
@LeetCode(id = 208, title = "实现 Trie (前缀树)", difficulty = Difficulty.MEDIUM)
public interface Trie {


    void insert(String word);

    boolean search(String word);

    boolean startsWith(String prefix);
}
