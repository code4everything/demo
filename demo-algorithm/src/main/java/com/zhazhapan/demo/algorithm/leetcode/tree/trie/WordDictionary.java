package com.zhazhapan.demo.algorithm.leetcode.tree.trie;

/**
 * @author pantao
 * @since 2018-12-26
 */
public class WordDictionary {

    private static final Character DOT = '.';

    private TrieNode root = null;

    public void addWord(String word) {
        if (root == null) {
            root = new TrieNode();
        }
        if (word != null && word.length() > 0) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                TrieNode[] children = node.children;
                node = children[idx];
                if (node == null) {
                    node = new TrieNode();
                    children[idx] = node;
                }
            }
            node.isWord = true;
        }
    }

    public boolean search(String word) {
        if (word == null || root == null) {
            return false;
        }
        return search(word, root, 0, word.length());
    }

    private boolean search(String word, TrieNode node, int start, int len) {
        if (start == len) {
            return node == null || node.isWord;
        }
        char c = word.charAt(start);
        if (c == DOT) {
            for (int i = 0; i < node.children.length; i++) {
                TrieNode aNode = node.children[i];
                if (aNode != null && search(word, aNode, start + 1, len)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode aNode = node.children[c - 'a'];
            if (aNode == null) {
                return false;
            }
            return search(word, aNode, start + 1, len);
        }
    }

    private class TrieNode {

        private boolean isWord = false;

        private TrieNode[] children = new TrieNode[26];
    }
}
