package org.dangerous.leetcode;


import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Map<Integer, List<Integer>> m = new HashMap<>(); // key:level value:val in this level
        travel(root, 0, m);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m.size(); i++) {
            result.add(m.get(i));
        }
        return result;
    }

    public void travel(TreeNode node, int level, Map<Integer, List<Integer>> m) {
        if (m.containsKey(level)) {
            if (level % 2 == 0) {
                ((LinkedList<Integer>) m.get(level)).addLast(node.val);
            } else {
                ((LinkedList<Integer>) m.get(level)).addFirst(node.val);
            }
        } else {
            List<Integer> l = new LinkedList<>();
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
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.right = right2;
        right.left = left2;
        List<List<Integer>> l = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);
        System.out.println(l);
    }
}
