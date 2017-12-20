package org.dangerous.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 * Created by limeng on 17-12-20.
 */
public class FindBottomLeftTreeValue {
    /**
     * BFS，查找最后一层最左面的数
     *
     * @param root
     * @return
     */
    public int findLeftMostNode(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return result;
    }
}
