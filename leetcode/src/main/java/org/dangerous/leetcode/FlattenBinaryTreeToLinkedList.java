package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        flatten(root, null);
    }

    /**
     * deep first 由低向上
     * @param root
     * @param pre
     * @return
     */
    private TreeNode flatten(TreeNode root, TreeNode pre) {
        if (root == null) return pre;
        pre = flatten(root.right, pre);
        pre = flatten(root.left, pre);
        root.right = pre;
        root.left = null;
        pre = root;
        return pre;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);

        root.left = root2;
        root2.left = root3;
        root2.right = root4;

        root.right = root5;
        root5.right = root6;
        root6.right = new TreeNode(7);

        new FlattenBinaryTreeToLinkedList().flatten(root);
        root.print();
    }
}
