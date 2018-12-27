package com.zhazhapan.demo.algorithm.leetcode.tree.trie;

/**
 * @author pantao
 * @since 2018/12/27
 **/
public class MaximumXORFinder {

    private TrieNode root = new TrieNode();

    public int findMaximumXOR(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            String bin = Integer.toBinaryString(nums[i]);
            TrieNode node = root;
            for (int j = bin.length() - 1; j > -1; j--) {
                int idx = bin.charAt(j) - '0';
                TrieNode[] children = node.children;
                node = children[idx];
                if (node == null) {
                    node = new TrieNode();
                    children[idx] = node;
                }
            }
        }
        return findMaximumXOR(0, root.children[0], root.children[1]);
    }

    private int findMaximumXOR(int depth, TrieNode left, TrieNode right) {
        boolean isLeftNull = left == null;
        boolean isRightNull = right == null;
        if (isLeftNull && isRightNull) {
            return 0;
        } else if (isLeftNull) {
            return (depth == 0 ? 0 : 1 << depth) + findMaximumXOR(depth + 1, null, right.children[1]);
        } else if (isRightNull) {
            return findMaximumXOR(depth + 1, null, left.children[1]);
        } else {
            int dep = depth + 1;
            int max = Math.max(findMaximumXOR(dep, left.children[0], left.children[1]), findMaximumXOR(dep,
                    right.children[0], right.children[1]));
            int newMax = Math.max(findMaximumXOR(dep, left.children[0], right.children[1]), findMaximumXOR(dep,
                    left.children[0], right.children[1]));
            return newMax > max ? newMax + (1 << newMax) : max;
        }
    }

    private class TrieNode {

        private TrieNode[] children = new TrieNode[2];
    }
}
