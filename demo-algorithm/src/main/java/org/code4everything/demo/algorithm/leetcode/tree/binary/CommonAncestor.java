package org.code4everything.demo.algorithm.leetcode.tree.binary;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;
import org.code4everything.demo.algorithm.leetcode.model.TreeNode;

/**
 * @author pantao
 * @since 2018-12-08
 */
public class CommonAncestor {

    @LeetCode(id = 235, difficulty = Difficulty.EASY, title = "二叉搜索树的最近公共祖先")
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
