package com.zhazhapan.demo.algorithm.leetcode.tree.binary.search;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;
import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

import java.util.Stack;

/**
 * @author pantao
 * @since 2018-12-11
 */
@LeetCode(id = 173, title = "二叉搜索树迭代器", difficulty = Difficulty.MEDIUM)
public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeftNode(root);
    }

    private void pushLeftNode(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        pushLeftNode(node.right);
        return node.val;
    }
}
