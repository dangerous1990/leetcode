package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        travel(0,root,map);
        for( int i=0; i< map.size();i++){
            list.add(map.get(i));
        }
        return list;
    }

    /**
     * 层序遍历，取最后一个元素
     * @param level
     * @param root
     * @param map
     */
    private void travel(int level, TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(level, root.val);
        travel(level + 1, root.left, map);
        travel(level + 1, root.right, map);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);

        root.left = root2;
        root.right = root3;
        root2.right = root5;
        root3.right = root4;
        System.out.println(new BinaryTreeRightSideView().rightSideView(root));

        TreeNode aroot1 = new TreeNode(1);
        TreeNode aroot2 = new TreeNode(2);
        aroot1.left = aroot2;
        System.out.println(new BinaryTreeRightSideView().rightSideView(aroot1));
    }
}
