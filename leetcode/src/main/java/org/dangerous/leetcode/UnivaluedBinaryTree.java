package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/univalued-binary-tree
 */
public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (null == root) {
            return true;
        }
        return travel(root, root.val);
    }

    private boolean travel(TreeNode root, int target) {
        if (null == root) {
            return true;
        }
        if (root.val == target) {
            return travel(root.left, target) && travel(root.right, target);
        } else {
            return false;
        }
    }
}
