package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 && right != 0) {
            return right + 1;
        }
        if (right == 0 && left != 0) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }

}
