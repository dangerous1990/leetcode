package org.dangerous.leetcode;

import java.util.LinkedList;

/**
 * Created by limeng on 17-11-29.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public void print() {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(this);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node ==null) {
                System.out.println("null");
            }
            if (null != node) {
                System.out.println(node.val);
                queue.push(node.left);
                queue.push(node.right);
            }
        }
    }

}
