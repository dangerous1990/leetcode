package org.dangerous.leetcode.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void backtrack(int index, int[] nums, List<List<Integer>> result, List<Integer> subset, int prevIndex) {
        result.add(new ArrayList<>(subset));
        if (index == nums.length) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = prevIndex; i < nums.length; i++) {
            if (set.add(nums[i])) {
                subset.add(nums[i]);
                swap(nums, index, i);
                backtrack(index + 1, nums, result, subset, i + 1);
                swap(nums, index, i);
                subset.remove(subset.size() - 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }

    public static void main(String[] args) {
        System.out.println(new SubSetsII().subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(new SubSetsII().subsetsWithDup(new int[]{1, 1, 2, 2}));
    }
}
