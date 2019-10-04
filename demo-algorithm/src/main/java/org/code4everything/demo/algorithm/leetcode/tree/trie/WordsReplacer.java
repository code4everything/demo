package org.code4everything.demo.algorithm.leetcode.tree.trie;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.List;

/**
 * @author pantao
 * @since 2018/12/25
 **/
public class WordsReplacer {

    private static final String SPACE = " ";

    private TrieNode root = new TrieNode();

    @LeetCode(id = 648, difficulty = Difficulty.MEDIUM, title = "单词替换")
    public String replaceWords(List<String> dict, String sentence) {
        for (String s : dict) {
            insert(s);
        }
        StringBuilder builder = new StringBuilder();
        for (String s : sentence.split(SPACE)) {
            builder.append(SPACE).append(replacePrefix(s));
        }
        return builder.substring(1);
    }

    private String replacePrefix(String word) {
        TrieNode node = root;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            builder.append(c);
            node = node.children[c - 'a'];
            if (node == null) {
                return word;
            } else if (node.isWord) {
                return builder.toString();
            }
        }
        return word;
    }

    private void insert(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            TrieNode[] children = node.children;
            node = children[idx];
            if (node == null) {
                node = new TrieNode();
                children[idx] = node;
            }
        }
        node.isWord = true;
    }

    private class TrieNode {

        private boolean isWord = false;

        private TrieNode[] children = new TrieNode[26];
    }
}
