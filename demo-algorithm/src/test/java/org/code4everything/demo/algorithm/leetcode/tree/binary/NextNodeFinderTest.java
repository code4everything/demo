package org.code4everything.demo.algorithm.leetcode.tree.binary;

import org.code4everything.demo.algorithm.leetcode.model.TreeLinkNode;
import org.junit.Test;

public class NextNodeFinderTest {

    @Test
    public void connect() {
        NextNodeFinder finder = new NextNodeFinder();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        long start = System.currentTimeMillis();
        finder.bestConnect(root);
        System.out.println("use time -> " + (System.currentTimeMillis() - start));
        assert root.next == null;
        assert root.left.next.val == root.right.val;
        assert root.left.left.next.val == root.left.right.val;
        assert root.left.right.next.val == root.right.left.val;
        assert root.right.left.next.val == root.right.right.val;
    }

    @Test
    public void connect2() {
        NextNodeFinder finder = new NextNodeFinder();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.right = new TreeLinkNode(7);
        long start = System.currentTimeMillis();
        finder.connect2(root);
        System.out.println("use time -> " + (System.currentTimeMillis() - start));
        assert root.next == null;
        assert root.left.next.val == root.right.val;
        assert root.left.left.next.val == root.left.right.val;
        assert root.left.right.next.val == root.right.right.val;
        // 测试2
        root = new TreeLinkNode(2);
        root.left = new TreeLinkNode(1);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(0);
        root.left.right = new TreeLinkNode(7);
        root.right.left = new TreeLinkNode(9);
        root.right.right = new TreeLinkNode(1);
        root.left.left.left = new TreeLinkNode(2);
        root.left.right.left = new TreeLinkNode(1);
        root.left.right.right = new TreeLinkNode(0);
        root.right.right.left = new TreeLinkNode(8);
        root.right.right.right = new TreeLinkNode(8);
        finder.connect2(root);
        assert root.left.right.right.next.val == root.right.right.left.val;
    }
}
