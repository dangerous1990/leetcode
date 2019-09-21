package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return travel(root, 0) != -1;
    }

    private int travel(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left = travel(root.left, depth);
        int right = travel(root.right, depth);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
