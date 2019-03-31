package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

/**
 * @author pantao
 * @since 2019/2/3
 **/
public class Contest988 {

    private static final char[] CHARS = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        String str = String.valueOf(CHARS[root.val]);
        boolean isLeftNull = root.left == null;
        boolean isRightNull = root.right == null;
        if (isLeftNull && isRightNull) {
            return str;
        } else if (isRightNull) {
            return smallestFromLeaf(root.left) + str;
        } else if (isLeftNull) {
            return smallestFromLeaf(root.right) + str;
        } else {
            String left = smallestFromLeaf(root.left) + str;
            String right = smallestFromLeaf(root.right) + str;
            return left.compareTo(right) < 0 ? left : right;
        }
    }
}
