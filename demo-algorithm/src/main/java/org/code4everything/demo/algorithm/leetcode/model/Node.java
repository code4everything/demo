package org.code4everything.demo.algorithm.leetcode.model;

import java.util.List;

/**
 * @author pantao
 * @since 2018-12-09
 */
public class Node {

    public int val;

    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
