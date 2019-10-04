package org.code4everything.demo.algorithm.leetcode.tree.nary;

import org.code4everything.demo.algorithm.leetcode.model.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2018-12-09
 */
public class LevelOrder {

    private List<List<Integer>> levelList = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        levelOrder(root, 0);
        return levelList;
    }

    private void levelOrder(Node root, int level) {
        if (root != null) {
            List<Integer> list;
            if (level < levelList.size()) {
                list = levelList.get(level);
            } else {
                list = new ArrayList<>();
                levelList.add(list);
            }
            list.add(root.val);
            List<Node> nodes = root.children;
            if (nodes != null && !nodes.isEmpty()) {
                for (Node node : nodes) {
                    levelOrder(node, level + 1);
                }
            }
        }
    }
}
