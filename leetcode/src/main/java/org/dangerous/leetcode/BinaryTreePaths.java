package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> paths = new LinkedList<>();
        List<String> result = new ArrayList<>();

        dfs(root, paths, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> paths, List<String> result) {
        if (root == null) {
            return;
        }
        paths.add(root.val);
        if (root.right == null && root.left == null) {
            result.add(buildPath(paths));
            return;
        }
        dfs(root.left, new LinkedList<>(paths), result);
        dfs(root.right, new LinkedList<>(paths), result);
    }


    private String buildPath(List<Integer> paths) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paths.size(); i++) {
            sb.append(paths.get(i)).append("->");
        }
        return sb.length() > 1 ? sb.substring(0, sb.length() - 2) : sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        left.left = new TreeNode(5);
        root.left = left;
        root.right = right;
        System.out.println(new BinaryTreePaths().binaryTreePaths(root));
    }
}
