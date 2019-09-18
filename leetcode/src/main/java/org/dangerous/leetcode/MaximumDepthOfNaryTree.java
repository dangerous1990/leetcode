package org.dangerous.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        return count(root);
    }

    private int count(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.size() == 0) {
            return 1;
        }
        // 查找所有子树中深度最大的
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int c = count(root.children.get(i));
            max = Math.max(max, c);
        }
        return max + 1;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        Node node3 = new Node(3, Arrays.asList(node5, node6));
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        Node node1 = new Node(1, Arrays.asList(node3, node2, node4));
        System.out.println(new MaximumDepthOfNaryTree().count(node1));
    }
}
