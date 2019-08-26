package org.dangerous.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(0, nums, result, new ArrayList<>());
        return result;
    }

    public void backtrace(int index, int[] nums, List<List<Integer>> result, List<Integer> path) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (appeared.add(nums[i])) {
                path.add(nums[i]);
                swap(nums, index, i);
                backtrace(index + 1, nums, result, path);
                path.remove(path.size() - 1);
                swap(nums, index, i);
            }

        }
    }

    private void swap(int[] nums, int i, int j) {
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{1, 1, 2}));
    }
}
