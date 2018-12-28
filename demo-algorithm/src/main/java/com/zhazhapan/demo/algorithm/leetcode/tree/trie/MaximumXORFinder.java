package com.zhazhapan.demo.algorithm.leetcode.tree.trie;

/**
 * @author pantao
 * @since 2018/12/27
 **/
public class MaximumXORFinder {

    public static final int THIRTY_ONE = 31;

    private TrieNode root;

    private String[] binnum;

    public int findMaximumXOR(int[] nums) {
        root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int j = THIRTY_ONE; j >= 0; j--) {
                int idx = ((1 << j) & num) > 0 ? 1 : 0;
                if (node.nodes[idx] == null) {
                    node.nodes[idx] = new TrieNode();
                }
                node = node.nodes[idx];
            }
        }
        int max = 0;
        TrieNode node = root;
        for (int num : nums) {
            int temp = 0;
            for (int i = THIRTY_ONE; i >= 0; i--) {

            }
            max = Math.max(max, temp);
        }
        return max;
    }

    private class TrieNode {

        private TrieNode[] nodes = new TrieNode[2];
    }
}
