package com.zhazhapan.demo.algorithm.leetcode.contest;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019-02-17
 */
public class Contest993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int count = 0;
            List<TreeNode> nexts = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i++) {
                TreeNode node = nodes.get(i);
                if (node.val == x || node.val == y) {
                    count++;
                    if (count == 2) {
                        return true;
                    }
                } else {
                    int cnt = 0;
                    if (node.left != null) {
                        nexts.add(node.left);
                        if (node.left.val == x || node.left.val == y) {
                            cnt++;
                        }
                    }
                    if (node.right != null) {
                        nexts.add(node.right);
                        if (node.right.val == x || node.right.val == y) {
                            cnt++;
                        }
                    }
                    if (cnt == 2) {
                        return false;
                    }
                }
            }
            nodes = nexts;
        }
        return false;
    }

}
