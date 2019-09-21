package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (null == root) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        travel(root, 0, sum, new ArrayList<>(), result);
        return result;
    }

    private void travel(TreeNode root, int sum, int equal, List<Integer> list, List<List<Integer>> result) {
        sum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == equal) {
                result.add(list);
            }
            return;
        }
        if (root.left != null) {
            travel(root.left, sum, equal, new ArrayList<>(list), result);
        }
        if (root.right != null) {
            travel(root.right, sum, equal, new ArrayList<>(list), result);
        }
    }
}
