package com.zhazhapan.demo.algorithm.leetcode.tree.nary;

import com.zhazhapan.demo.algorithm.leetcode.model.Node;

import java.util.List;

/**
 * @author pantao
 * @since 2018-12-09
 */
public class MaxDepth {

    public int maxDepth(Node root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        List<Node> nodes = root.children;
        if (nodes != null && !nodes.isEmpty()) {
            for (Node node : nodes) {
                max = Math.max(max, maxDepth(node));
            }
        }
        return max + 1;
    }
}
