package com.zhazhapan.demo.algorithm.leetcode.tree.binary;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeLinkNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2018-12-04
 */
public class NextNodeFinder {

    private List<List<TreeLinkNode>> treeNodes = new ArrayList<>();

    public void connect2(TreeLinkNode root) {
        if (root != null) {
            TreeLinkNode node = root.left;
            if (node == null) {
                node = root.right;
            } else if (root.right != null) {
                node.next = root.right;
                node = root.right;
            }
            if (node != null) {
                TreeLinkNode nextRoot = root.next;
                while (nextRoot != null) {
                    if (nextRoot.left != null) {
                        node.next = nextRoot.left;
                        break;
                    } else if (nextRoot.right != null) {
                        node.next = nextRoot.right;
                        break;
                    } else {
                        nextRoot = nextRoot.next;
                    }
                }
            }
            // 先构建右边
            connect2(root.right);
            connect2(root.left);
        }
    }

    private void findNext(TreeLinkNode root, TreeLinkNode previous) {
        if (root != null) {

        }
    }

    public void bestConnect(TreeLinkNode root) {
        if (root != null && root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            bestConnect(root.left);
            bestConnect(root.right);
        }
    }

    public void connect(TreeLinkNode root) {
        if (root != null && root.left != null) {
            findNext(root, 0);
        }
    }

    private void findNext(TreeLinkNode root, int level) {
        if (root.left == null) {
            return;
        }
        root.left.next = root.right;
        List<TreeLinkNode> levelNodes;
        if (level >= treeNodes.size()) {
            levelNodes = new ArrayList<>();
            treeNodes.add(levelNodes);
        } else {
            levelNodes = treeNodes.get(level);
            levelNodes.get(levelNodes.size() - 1).next = root.left;
        }
        levelNodes.add(root.left);
        levelNodes.add(root.right);
        findNext(root.left, level + 1);
        findNext(root.right, level + 1);
    }
}
