package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (null == root) return 0;
        List<List<Integer>> result = new ArrayList<>();
        travel(root, new ArrayList<>(), result);
        int totalSum = 0;
        int n = result.size();
        for (int i = 0; i < n; i++) {
            int length = result.get(i).size();
            int sum = 0;
            for (int j = 0; j < length; j++) {
                sum += Math.pow(10, length - 1 - j) * result.get(i).get(j);
            }
            totalSum += sum;
        }
        return totalSum;
    }

    private void travel(TreeNode root, List<Integer> list, List<List<Integer>> result) {
        list.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        if (root.left != null) {
            travel(root.left, list, result);
        }
        if (root.right != null) {
            travel(root.right, list, result);
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(new SumRootToLeafNumbers().sumNumbers(node1));
    }
}
