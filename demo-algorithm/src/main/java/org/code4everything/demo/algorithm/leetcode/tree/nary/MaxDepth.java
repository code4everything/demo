package org.code4everything.demo.algorithm.leetcode.tree.nary;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;
import org.code4everything.demo.algorithm.leetcode.model.Node;

import java.util.List;

/**
 * @author pantao
 * @since 2018-12-09
 */
public class MaxDepth {

    @LeetCode(id = 559, difficulty = Difficulty.EASY, title = "N叉树的最大深度")
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
