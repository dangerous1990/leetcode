package org.dangerous.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Map<Integer, List<Integer>> m = new HashMap<>(); // key:level value:val in this level
        travel(root, 0, m);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = m.size()-1; i < m.size(); i--) {
            if (!m.containsKey(i)) {
                break;
            }
            result.add(m.get(i));
        }
        return result;
    }

    public void travel(TreeNode node, int level, Map<Integer, List<Integer>> m) {
        if (m.containsKey(level)) {
            m.get(level).add(node.val);
        } else {
            List<Integer> l = new ArrayList<>();
            l.add(node.val);
            m.put(level, l);
        }
        if (node.left != null) {
            travel(node.left, level + 1, m);
        }
        if (node.right != null) {
            travel(node.right, level + 1, m);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(8);
        TreeNode right2 = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.right = right2;
        new BinaryTreeLevelOrderTraversal2().levelOrderBottom(root);
    }
}
