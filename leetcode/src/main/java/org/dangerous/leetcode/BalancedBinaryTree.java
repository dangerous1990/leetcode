package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return travel(root) != -1;
    }

    private int travel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = travel(root.left);
        int right = travel(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
