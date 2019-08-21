package org.dangerous.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtrace(0, nums, result, new ArrayList<>());
        return result;
    }

    public void backtrace(int index, int[] nums, List<List<Integer>> result, List<Integer> path) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrace(index + 1, nums, result, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
    }
}
