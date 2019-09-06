package com.zhazhapan.demo.algorithm.leetcode.tree.binary.search;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;
import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019/4/23
 **/
public class Solution {

    TreeNode pre;

    int min = Integer.MAX_VALUE;

    private int cnt = 0;

    private List<TreeNode> none = new ArrayList<>();

    @LeetCode(id = 783, title = "二叉搜索树结点最小距离", difficulty = Difficulty.EASY)
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (pre != null) {
            min = Math.min(min, node.val - pre.val);
        }
        pre = node;
        inorder(node.right);
    }

    @LeetCode(id = 95, title = "不同的二叉搜索树 II", difficulty = Difficulty.MEDIUM)
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return none;
        }
        none.add(null);
        return treeHelper(1, n);
    }

    private List<TreeNode> treeHelper(int low, int high) {
        if (low > high) {
            return none;
        }
        List<TreeNode> list = new ArrayList<>();
        for (int min = low; min <= high; min++) {
            List<TreeNode> lefts = treeHelper(low, min - 1);
            List<TreeNode> rights = treeHelper(min + 1, high);
            int len = lefts.size() * rights.size();
            for (int i = 0; i < len; i++) {
                TreeNode curr = new TreeNode(min);
                curr.left = lefts.get(i % lefts.size());
                curr.right = rights.get(i / lefts.size());
                list.add(curr);
            }
        }
        return list;
    }

    @LeetCode(id = 230, title = "二叉搜索树中第K小的元素", difficulty = Difficulty.MEDIUM)
    public int kthSmallest(TreeNode root, int k) {
        if (root.left != null) {
            int s = kthSmallest(root.left, k);
            if (s != -1 || cnt == k) {
                return s;
            }
        }
        if (++cnt == k) {
            return root.val;
        }
        if (root.right != null) {
            int s = kthSmallest(root.right, k);
            if (s != -1 || cnt == k) {
                return s;
            }
        }
        return -1;
    }
}
