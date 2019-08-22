package org.dangerous.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void backtrack(int index, int[] nums, List<List<Integer>> result, List<Integer> subset, int prevIndex) {
        result.add(new ArrayList<>(subset));
        if (index == nums.length) {
            return;
        }
        for (int i = prevIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(index + 1, nums, result, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SubSets().subsets(new int[]{1, 2, 3}));
    }
}
