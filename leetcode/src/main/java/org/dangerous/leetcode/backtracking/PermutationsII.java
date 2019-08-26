package org.dangerous.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(0, nums, result, new ArrayList<>(), new ArrayList<>());
        return result;
    }

    public void backtrace(int index, int[] nums, List<List<Integer>> result, List<Integer> path, List<Integer> indexPath) {
        if (index == nums.length) {
            if (result.contains(path)) {
                return;
            }
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (indexPath.contains(i)) {
                continue;
            }
            path.add(nums[i]);
            indexPath.add(i);
            backtrace(index + 1, nums, result, path, indexPath);
            path.remove(path.size() - 1);
            indexPath.remove(indexPath.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{1, 1, 2}));
    }
}
