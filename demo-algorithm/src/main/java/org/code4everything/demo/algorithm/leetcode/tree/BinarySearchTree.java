package org.code4everything.demo.algorithm.leetcode.tree;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;
import org.code4everything.demo.algorithm.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author pantao
 * @since 2018-12-10
 */
public class BinarySearchTree {

    private List<List<Boolean>> lists = new ArrayList<>();

    private int max = 0;

    @LeetCode(id = 662, title = "二叉树最大宽度", difficulty = Difficulty.MEDIUM)
    public int widthOfBinaryTree(TreeNode root) {
        widthHelper(root, 0);
        return max;
    }

    private void widthHelper(TreeNode node, int level) {
        List<Boolean> list;
        if (level < lists.size()) {
            list = lists.get(level);
        } else {
            list = new ArrayList<>();
            lists.add(list);
        }
        int nextLevel = level + 1;
        if (list.size() > 0) {
            boolean isNull = node == null;
            list.add(!isNull);
            if (isNull) {
                widthHelper(null, nextLevel);
                widthHelper(null, nextLevel);
            } else {
                max = Math.max(max, list.size());
                widthHelper(node.left, nextLevel);
                widthHelper(node.right, nextLevel);
            }
        } else if (node != null) {
            list.add(true);
            max = Math.max(max, 1);
            widthHelper(node.left, nextLevel);
            widthHelper(node.right, nextLevel);
        }
    }

    @LeetCode(id = 108, title = "将有序数组转换为二叉搜索树", difficulty = Difficulty.EASY)
    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null || nums.length == 0 ? null : sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        int idx = (end + start) / 2;
        TreeNode root = new TreeNode(nums[idx]);
        if (idx > start) {
            root.left = sortedArrayToBST(nums, start, idx - 1);
        }
        if (idx < end) {
            root.right = sortedArrayToBST(nums, idx + 1, end);
        }
        return root;
    }

    @LeetCode(id = 110, title = "平衡二叉树", difficulty = Difficulty.EASY)
    public boolean isBalanced(TreeNode root) {
        return depth(root) >= 0;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        if (leftDepth < 0) {
            return -1;
        }
        int rightDepth = depth(root.right);
        if (rightDepth < 0 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }

    @LeetCode(id = 220, difficulty = Difficulty.MEDIUM, title = "存在重复元素 III")
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length > 1 && k > 0 && t >= 0) {
            SortedSet<Long> binaryTree = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                SortedSet<Long> sonSet = binaryTree.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
                if (sonSet.isEmpty()) {
                    if (i >= k) {
                        binaryTree.remove((long) nums[i - k]);
                    }
                    binaryTree.add((long) nums[i]);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    @LeetCode(id = 450, difficulty = Difficulty.MEDIUM, title = "删除二叉搜索树中的节点")
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            boolean isLeftNull = root.left == null;
            boolean isRightNull = root.right == null;
            if (isLeftNull && isRightNull) {
                return null;
            } else if (isRightNull) {
                return root.left;
            } else if (isLeftNull) {
                return root.right;
            } else {
                if (root.left.right == null) {
                    root.left.right = root.right;
                    return root.left;
                }
                // 最后一个右子节点的父节点
                TreeNode pre = root.left;
                while (pre.right.right != null) {
                    pre = pre.right;
                }
                // 最后一个右子节点
                TreeNode current = pre.right;
                pre.right = current.left;
                current.left = root.left;
                current.right = root.right;
                return current;
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    @LeetCode(id = 701, difficulty = Difficulty.MEDIUM, title = "二叉搜索树中的插入操作")
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode childNode = new TreeNode(val);
        if (root == null) {
            return childNode;
        }
        TreeNode node = root;
        while (true) {
            if (node.val == val) {
                break;
            } else if (node.val > val) {
                if (node.left == null) {
                    node.left = childNode;
                    break;
                } else {
                    node = node.left;
                }
            } else if (node.right == null) {
                node.right = childNode;
                break;
            } else {
                node = node.right;
            }
        }
        return root;
    }

    @LeetCode(id = 700, difficulty = Difficulty.EASY, title = "二叉搜索树中的搜索")
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    @LeetCode(id = 98, title = "验证二叉搜索树", difficulty = Difficulty.MEDIUM)
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        boolean res = true;
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            res = root.val > root.left.val && root.left.val > min;
        }
        if (res && root.right != null) {
            res = root.right.val > root.val && root.right.val < max;
        }
        return res && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
