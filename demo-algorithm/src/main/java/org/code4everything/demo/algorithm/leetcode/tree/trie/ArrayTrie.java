package org.code4everything.demo.algorithm.leetcode.tree.trie;

/**
 * @author pantao
 * @since 2018-12-22
 */
public class ArrayTrie implements Trie {

    private TrieNode root = new TrieNode();

    @Override
    public void insert(String word) {
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

    @Override
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode node = findNode(word);
        return node != null && node.isWord;
    }

    @Override
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.children[word.charAt(i) - 'a'];
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    private class TrieNode {

        private boolean isWord = false;

        private TrieNode[] children = new TrieNode[26];
    }
}
