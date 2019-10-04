package org.code4everything.demo.algorithm.leetcode.tree.nary;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;
import org.code4everything.demo.algorithm.leetcode.model.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2018-12-09
 */
public class Preorder {

    private List<Integer> list = new ArrayList<>();

    @LeetCode(id = 589, difficulty = Difficulty.EASY, title = "N叉树的前序遍历")
    public List<Integer> preorder(Node root) {
        pre(root);
        return list;
    }

    private void pre(Node root) {
        if (root != null) {
            list.add(root.val);
            List<Node> nodes = root.children;
            if (nodes != null && !nodes.isEmpty()) {
                for (Node node : nodes) {
                    pre(node);
                }
            }
        }
    }
}
