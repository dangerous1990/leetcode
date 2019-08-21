package org.dangerous.leetcode.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtrace(0,nums,result,new ArrayList<>(),new HashSet<>());
        return result;
    }

    public void backtrace(int index, int[] nums, List<List<Integer>> result, List<Integer> path, Set<Integer> uniq) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (uniq.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            uniq.add(nums[i]);
            backtrace(index + 1, nums, result, path, uniq);
            uniq.remove(nums[i]);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1,2,3}));
    }
}
