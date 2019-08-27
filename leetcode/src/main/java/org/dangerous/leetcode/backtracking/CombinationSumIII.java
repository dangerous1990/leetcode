package org.dangerous.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii
 */
public class CombinationSumIII {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int target) {
        backtrace(new ArrayList<>(), 0, k, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, target, 0);
        return result;
    }

    public void backtrace(List<Integer> x, int index, int length, int[] candidates, int target, int prevIndex) {
        if (target < 0) {
            return;
        }
        if (0 == target && index == length) {
            result.add(new ArrayList<>(x));
            return;
        }
        for (int i = prevIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            x.add(candidates[i]);
            backtrace(x, index + 1, length, candidates, target - candidates[i], i + 1);
            x.remove(x.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII s = new CombinationSumIII();
        System.out.println(s.combinationSum3(3, 9));
    }

}
