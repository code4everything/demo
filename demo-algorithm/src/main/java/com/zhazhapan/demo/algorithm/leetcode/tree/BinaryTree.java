package com.zhazhapan.demo.algorithm.leetcode.tree;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pantao
 * @since 2018/9/25
 **/
public class BinaryTree {

    private List<List<Integer>> traversalResultList = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(9);
        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;
        // 前序遍历
        List<Integer> preOrder = new ArrayList<Integer>(8) {{addAll(Arrays.asList(9, 8, 7));}};
        Assert.assertEquals(preOrder, binaryTree.preOrderTraversal(root));
        // 中序遍历
        List<Integer> inOrder = new ArrayList<Integer>(8) {{addAll(Arrays.asList(8, 9, 7));}};
        Assert.assertEquals(inOrder, binaryTree.inOrderTraversal(root));
        // 后序遍历
        List<Integer> postOrder = new ArrayList<Integer>(8) {{addAll(Arrays.asList(8, 7, 9));}};
        Assert.assertEquals(postOrder, binaryTree.postOrderTraversal(root));
        // 层级遍历
        List<List<Integer>> levelOrder = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{add(9);}});
            add(new ArrayList<Integer>() {{
                add(8);
                add(7);
            }});
        }};
        Assert.assertEquals(levelOrder, binaryTree.levelOrder(root));
        // 最大深度
        Assert.assertEquals(2, binaryTree.maxDepth(root));
        // 是否镜像对称
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        Assert.assertTrue(binaryTree.isSymmetric(root));
        root.right.right.val = 7;
        Assert.assertFalse(binaryTree.isSymmetric(root));
        // 路径总和
        Assert.assertFalse(binaryTree.hasPathSum(root, 89));
        Assert.assertTrue(binaryTree.hasPathSum(root, 15));
        // 构建二叉树
        int[] inorder = binaryTree.inOrderTraversal(root).stream().mapToInt(i -> i).toArray();
        int[] postorder = binaryTree.postOrderTraversal(root).stream().mapToInt(i -> i).toArray();
        binaryTree.buildTree(inorder, postorder);
    }

    /**
     * 构建二叉树
     *
     * @param inorder 中序遍历结果
     * @param postorder 后续遍历结果
     *
     * @return {@link TreeNode}
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return null;
    }


    /**
     * 路径总和
     *
     * @param root {@link TreeNode}
     * @param sum 目标和
     *
     * @return 是否存在一条路径和等于目标和
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }

    /**
     * 是否镜像对称
     *
     * @param root {@link TreeNode}
     *
     * @return 是否镜像对称
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 最大深度
     *
     * @param root {@link TreeNode}
     *
     * @return 最大深度
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 层级遍历
     *
     * @param root {@link TreeNode}
     *
     * @return {@link List}
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            traversalResultList.add(list);
            levelOrder(root, 1);
        }
        return traversalResultList;
    }

    private void levelOrder(TreeNode node, int level) {
        List<Integer> list;
        if (traversalResultList.size() > level) {
            list = traversalResultList.get(level);
        } else {
            list = new ArrayList<>();
            if (node.left != null || node.right != null) {
                traversalResultList.add(list);
            }
        }
        if (node.left != null) {
            list.add(node.left.val);
            levelOrder(node.left, level + 1);
        }
        if (node.right != null) {
            list.add(node.right.val);
            levelOrder(node.right, level + 1);
        }
    }

    /**
     * 后续遍历
     *
     * @param root {@link TreeNode}
     *
     * @return {@link List}
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            if (root.left != null) {
                list.addAll(postOrderTraversal(root.left));
            }
            if (root.right != null) {
                list.addAll(postOrderTraversal(root.right));
            }
            list.add(root.val);
        }
        return list;
    }

    /**
     * 中序遍历
     *
     * @param root {@link TreeNode}
     *
     * @return {@link List}
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            if (root.left != null) {
                list.addAll(inOrderTraversal(root.left));
            }
            list.add(root.val);
            if (root.right != null) {
                list.addAll(inOrderTraversal(root.right));
            }
        }
        return list;
    }

    /**
     * 前序遍历
     *
     * @param root {@link TreeNode}
     *
     * @return {@link List}
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                list.addAll(preOrderTraversal(root.left));
            }
            if (root.right != null) {
                list.addAll(preOrderTraversal(root.right));
            }
        }
        return list;
    }

    /**
     * 最佳解决方案
     *
     * @param root {@link TreeNode}
     *
     * @return 成绩遍历结果
     */
    public List<List<Integer>> bestLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }

    private void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root != null) {
            if (height >= res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(height).add(root.val);
            levelHelper(res, root.left, height + 1);
            levelHelper(res, root.right, height + 1);
        }
    }
}
