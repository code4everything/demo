package org.code4everything.demo.algorithm.leetcode.tree.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pantao
 * @since 2018-12-22
 */
public class MapTrie implements Trie {

    private TrieNode root = new TrieNode();

    public MapTrie() {}

    @Override
    public void insert(String word) {
        if (word != null && word.length() > 0) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Map<Character, TrieNode> children = node.children;
                node = children.get(c);
                if (node == null) {
                    node = new TrieNode();
                    children.put(c, node);
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
            node = node.children.get(word.charAt(i));
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    private class TrieNode {

        private boolean isWord = false;

        private Map<Character, TrieNode> children = new HashMap<>();
    }
}
