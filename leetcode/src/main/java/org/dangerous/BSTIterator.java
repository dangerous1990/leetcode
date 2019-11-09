package org.dangerous;

import org.dangerous.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {
    private int index = 0;
    List<Integer> elements = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        travel(root);

    }

    private void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        travel(root.left);
        elements.add(root.val);
        travel(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (index > elements.size()) {
            throw new IndexOutOfBoundsException();
        }
        return elements.get(index++);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return index < elements.size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(15);
        TreeNode left3 = new TreeNode(9);
        TreeNode right4 = new TreeNode(20);
        root.left = left;
        root.right = right;
        right.left = left3;
        right.right = right4;
        BSTIterator it = new BSTIterator(root);
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
