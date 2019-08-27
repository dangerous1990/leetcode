package org.dangerous.leetcode.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(new ArrayList<>(), 0, candidates, target, 0);
        return result;
    }

    public void backtrace(List<Integer> x, int index, int[] candidates, int target, int prevIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(x));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = prevIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            if (set.add(candidates[i])) {
                int cur = candidates[i];
                x.add(candidates[i]);
                swap(candidates, index, i);
                backtrace(x, index + 1, candidates, target - cur, i + 1);
                swap(candidates, index, i);
                x.remove(x.size() - 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }


    public static void main(String[] args) {
        CombinationSumII s = new CombinationSumII();
        System.out.println(s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(s.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(s.combinationSum2(new int[]{1}, 1));
    }
}
