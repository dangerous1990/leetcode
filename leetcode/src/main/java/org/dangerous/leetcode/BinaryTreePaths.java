package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by limeng on 18-6-22.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> paths = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        if(null != root){
            stack.push(root);
        }
        Map<Integer,Integer> levels = new HashMap<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            paths.add(node.val);
            if (node.left == null && node.right == null) {
                result.add(buildPath(paths));
                paths.clear();
                paths.add(root.val);
            }
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
        return result;
    }

    private String buildPath(List<Integer> paths) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paths.size(); i++) {
            sb.append(paths.get(i)).append("->");
        }
        return sb.length() > 1 ? sb.substring(0, sb.length() - 2) : sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left =  new TreeNode(1);
        TreeNode right =  new TreeNode(2);
        left.left = new TreeNode(3);
        root.left = left;
        root.right = right;
        BinaryTreePaths btp = new BinaryTreePaths();
        List<String> result = btp.binaryTreePaths(root);
        System.out.println(result);
        Arrays.toString(result.toArray());
    }
}
