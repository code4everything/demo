package com.zhazhapan.demo.algorithm.leetcode.tree.binary.search;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;
import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

/**
 * @author pantao
 * @since 2019/4/23
 **/
public class Solution {

    private int cnt = 0;

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
