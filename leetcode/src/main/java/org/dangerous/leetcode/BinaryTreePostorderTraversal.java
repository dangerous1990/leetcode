package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 后序遍历，先遍历左子树与右子树，后遍历根节点
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        travel(root,list);
        return list;
    }

    public void travel(TreeNode node, List<Integer> result) {
        if (node != null){
            travel(node.left, result);
            travel(node.right, result);
            result.add(node.val);
        }
    }
}
