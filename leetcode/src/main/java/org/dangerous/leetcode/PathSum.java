package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) return false;
        return travel(root, 0, sum);
    }

    private boolean travel(TreeNode root, int sum, int equal) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == equal;
        }
        boolean left = false;
        if (root.left != null) {
            left = travel(root.left, sum, equal);
        }
        boolean right = false;
        if (root.right != null) {
            right = travel(root.right, sum, equal);
        }
        return left | right;
    }
}
