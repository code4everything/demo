package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

/**
 * @author pantao
 * @since 2018/12/30
 **/
public class Contest965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode node, int finalVal) {
        if (node == null) {
            return true;
        }
        if (node.val == finalVal) {
            return isUnivalTree(node.left, finalVal) && isUnivalTree(node.right, finalVal);
        }
        return false;
    }
}
