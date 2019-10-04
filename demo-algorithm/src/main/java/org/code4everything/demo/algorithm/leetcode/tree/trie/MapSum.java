package org.code4everything.demo.algorithm.leetcode.tree.trie;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pantao
 * @since 2018-12-24
 */
@LeetCode(id = 677, difficulty = Difficulty.MEDIUM, title = "键值映射")
public class MapSum {

    private TrieNode root = new TrieNode();

    public void insert(String key, int val) {
        if (key != null && key.length() > 0) {
            TrieNode node = root;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                Map<Character, TrieNode> children = node.children;
                node = children.get(c);
                if (node == null) {
                    node = new TrieNode();
                    children.put(c, node);
                }
            }
            node.value = val;
        }
    }

    public int sum(String prefix) {
        prefix = prefix == null ? "" : prefix;
        TrieNode node = root;
        int sum = 0;
        for (int i = 0; i < prefix.length(); i++) {
            node = node.children.get(prefix.charAt(i));
            if (node == null) {
                return sum;
            }
        }
        return sum(0, node);
    }

    private int sum(int sum, TrieNode node) {
        if (node != null) {
            sum += node.value;
            for (TrieNode value : node.children.values()) {
                sum += sum(0, value);
            }
        }
        return sum;
    }

    private class TrieNode {

        private int value = 0;

        private Map<Character, TrieNode> children = new HashMap<>();
    }
}
