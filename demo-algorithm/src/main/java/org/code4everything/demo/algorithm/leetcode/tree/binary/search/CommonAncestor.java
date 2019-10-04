package org.code4everything.demo.algorithm.leetcode.tree.binary.search;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;
import org.code4everything.demo.algorithm.leetcode.model.TreeNode;

/**
 * @author pantao
 * @since 2018/12/18
 **/
public class CommonAncestor {

    @LeetCode(id = 235, title = "二叉搜索树的最近公共祖先", difficulty = Difficulty.EASY)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
