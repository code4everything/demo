package org.code4everything.demo.algorithm.leetcode.tree;

import org.code4everything.demo.algorithm.leetcode.model.TreeNode;
import org.code4everything.demo.algorithm.leetcode.tree.binary.TreeCodec;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void isValidBST() {
        TreeCodec codec = new TreeCodec();
        BinarySearchTree tree = new BinarySearchTree();
        assert tree.isValidBST(codec.deserialize("2,1,3"));
        assert !tree.isValidBST(codec.deserialize("5,1,(4,3,6)"));
        assert !tree.isValidBST(codec.deserialize("10,5,(15,6,20)"));
        assert tree.isValidBST(codec.deserialize("-2147483648,null,2147483647"));

    }

    @Test
    public void searchBST() {
        TreeCodec codec = new TreeCodec();
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = codec.deserialize("4,(2,1,3),7");
        assert "(2,1,3)".equals(codec.serialize(tree.searchBST(root, 2)));
        assert "".equals(codec.serialize(tree.searchBST(root, 5)));
    }

    @Test
    public void insertIntoBST() {
        TreeCodec codec = new TreeCodec();
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = codec.deserialize("4,(2,1,3),7");
        System.out.println(codec.serialize(tree.insertIntoBST(root, 5)));
    }

    @Test
    public void deleteNode() {
        TreeCodec codec = new TreeCodec();
        BinarySearchTree tree = new BinarySearchTree();
        assert "".equals(codec.serialize(tree.deleteNode(codec.deserialize("5"), 5)));
        System.out.println(codec.serialize(tree.deleteNode(codec.deserialize("5,3,6"), 5)));
        TreeNode root = codec.deserialize("5,(3,2,4),(6,null,7)");
        System.out.println(codec.serialize(tree.deleteNode(root, 3)));
        System.out.println(codec.serialize(tree.deleteNode(root, 5)));
        System.out.println(codec.serialize(tree.deleteNode(codec.deserialize("11,(9,(2,1,(3,null,(5,4))),10)"), 9)));
    }

    @Test
    public void containsNearbyAlmostDuplicate() {
        BinarySearchTree tree = new BinarySearchTree();
        assert tree.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
        assert tree.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2);
        assert !tree.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
        assert !tree.containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647);
        assert !tree.containsNearbyAlmostDuplicate(new int[]{2147483647, -2147483647}, 1, 2147483647);
    }

    @Test
    public void isBalanced() {
        TreeCodec codec = new TreeCodec();
        BinarySearchTree tree = new BinarySearchTree();
        assert tree.isBalanced(codec.deserialize("3,9,(20,15,7)"));
        assert !tree.isBalanced(codec.deserialize("1,(2,(3,4,4),3),2"));
        assert tree.isBalanced(codec.deserialize("3,9,(20,15)"));
    }

    @Test
    public void sortedArrayToBST() {
        TreeCodec codec = new TreeCodec();
        BinarySearchTree tree = new BinarySearchTree();
        assert tree.isBalanced(tree.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
        assert tree.isBalanced(tree.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        assert tree.isBalanced(tree.sortedArrayToBST(new int[]{1}));
        assert tree.isBalanced(tree.sortedArrayToBST(null));
    }
}
