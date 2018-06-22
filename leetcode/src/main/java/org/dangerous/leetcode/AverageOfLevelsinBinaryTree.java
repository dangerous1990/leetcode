package org.dangerous.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 * Created by limeng on 18-2-12.
 */
public class AverageOfLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        int level = 0;
        stack.push(root);
        result.add(Double.valueOf(root.val));
        Map<Integer, Integer> map = new HashMap<>();
        while (!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            if (parent.left != null) {
                stack.push(parent.left);
            }
            if (parent.right != null) {
                stack.push(parent.right);
            }
        }
        return result;
    }
}
