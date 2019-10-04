package org.code4everything.demo.algorithm.leetcode.tree.binary;

import org.code4everything.demo.algorithm.leetcode.model.TreeNode;

/**
 * @author pantao
 * @since 2018-12-08
 */
public class TreeCodec {

    private static final String NULL = "null";

    private static final String LEFT_PARENTHESES = "(";

    private static final String RIGHT_PARENTHESES = ")";

    private static final String COMMA = ",";

    public String serialize(TreeNode root) {
        return serialize(root, false);
    }

    private String serialize(TreeNode root, boolean buildNull) {
        if (root == null) {
            return buildNull ? NULL : "";
        }
        StringBuilder result = new StringBuilder();
        // 有子节点的用括号包裹
        boolean hasChild = root.left != null || root.right != null;
        if (hasChild) {
            result.append(LEFT_PARENTHESES);
        }
        result.append(root.val);
        String left = serialize(root.left, root.right != null);
        String right = serialize(root.right, false);
        if (left.length() > 0) {
            result.append(COMMA).append(left);
        }
        if (right.length() > 0) {
            result.append(COMMA).append(right);
        }
        if (hasChild) {
            result.append(RIGHT_PARENTHESES);
        }
        return result.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 1 || NULL.equals(data)) {
            return null;
        }
        // 去掉包裹的括号
        if (data.startsWith(LEFT_PARENTHESES)) {
            data = data.substring(1, data.length() - 1);
        }
        // 构建根节点
        int idx = data.indexOf(COMMA);
        if (idx < 0) {
            return new TreeNode(Integer.parseInt(data));
        }
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(0, idx)));
        data = data.substring(idx + 1);
        // 找到左右子树的分隔索引
        if (!data.startsWith(LEFT_PARENTHESES)) {
            idx = data.indexOf(COMMA);
        } else if (!data.endsWith(RIGHT_PARENTHESES)) {
            idx = data.lastIndexOf(COMMA);
        } else {
            int count = 0;
            for (idx = 1; idx < data.length() - 1; idx++) {
                int c = data.charAt(idx);
                if (c == 41) {
                    if (count < 1) {
                        break;
                    } else {
                        count--;
                    }
                } else if (c == 40) {
                    count++;
                }
            }
            idx++;
        }
        // 构建左右子树
        if (idx < 0 || idx >= data.length() - 1) {
            root.left = deserialize(data);
        } else {
            root.left = deserialize(data.substring(0, idx));
            root.right = deserialize(data.substring(idx + 1));
        }
        return root;
    }
}
