package com.zhazhapan.demo.algorithm.leetcode.tree.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019-01-02
 */
public class PairPalindrome {

    private TrieNode root;

    private List<List<Integer>> list;

    private int emptyIdx = -1;

    public List<List<Integer>> palindromePairs(String[] words) {
        root = new TrieNode();
        list = new ArrayList<>();
        for (int x = 0; x < words.length; x++) {
            TrieNode node = root;
            if (words[x].length() == 0) {
                emptyIdx = x;
            } else {
                for (int i = words[x].length() - 1; i >= 0; i--) {
                    int idx = words[x].charAt(i) - 'a';
                    TrieNode[] children = node.children;
                    node = children[idx];
                    if (node == null) {
                        node = new TrieNode();
                        children[idx] = node;
                    }
                }
                node.word = words[x];
                node.idx = x;
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (emptyIdx > -1 && i != emptyIdx && isValid(words[i])) {
                add(i, emptyIdx);
            }
            palindromePairs(words[i], i, root, 0, words[i].length());
        }
        return list;
    }

    private void palindromePairs(String word, int i, TrieNode root, int idx, int len) {
        if (idx < len) {
            TrieNode node = root.children[word.charAt(idx) - 'a'];
            if (node != null) {
                if (node.idx > -1 && i != node.idx && isValid(word + node.word)) {
                    add(i, node.idx);
                }
                palindromePairs(word, i, node, idx + 1, len);
            }
        } else {
            findWords(root, i, len);
        }
    }

    private void add(int i, int j) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        this.list.add(list);
    }

    private void findWords(TrieNode root, int idx, int len) {
        for (int i = 0; i < 26; i++) {
            TrieNode node = root.children[i];
            if (node != null) {
                if (node.idx > -1 && idx != node.idx && isValid(node.word.substring(0, node.word.length() - len))) {
                    add(idx, node.idx);
                }
                findWords(node, idx, len);
            }
        }
    }

    private boolean isValid(String word) {
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(i) != word.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private class TrieNode {

        private int idx = -1;

        private String word = null;

        private TrieNode[] children = new TrieNode[26];
    }
}
