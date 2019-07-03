package org.dangerous.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Map<Integer, List<Integer>> m = new HashMap<>(); // key:level value:val in this level
        travel(root, 0, m);
        List<List<Integer>> result = new ArrayList<>();
        for (int i =0; i < m.size(); i++) {
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
}
