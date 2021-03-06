package org.dangerous.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 * Created by limeng on 17-12-6.
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int d) {
        if (root == null) {
            return;
        }
        //expand list size
        if (d == res.size()) {
            res.add(root.val);
        } else {
            //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d + 1);
        helper(root.right, res, d + 1);
    }

}
