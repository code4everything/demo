package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;
import org.code4everything.demo.algorithm.leetcode.model.TreeNode;

/**
 * @author pantao
 * @since 2018/12/30
 **/
public class Contest965 {

    @LeetCode(id = 965, difficulty = Difficulty.MEDIUM, title = "单值二叉树")
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
