package org.dangerous.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(new ArrayList<>(), 0, candidates, target, 0, 0);
        return result;
    }

    public void backtrace(List<Integer> x, int index, int[] candidates, int target, int prevIndex, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(x));
            return;
        }
        for (int i = prevIndex; i < candidates.length; i++) {
            x.add(candidates[i]);
            sum += candidates[i];
            backtrace(x, index + 1, candidates, target, i, sum);
            sum -= candidates[i];
            x.remove(x.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum s = new CombinationSum();
        System.out.println(s.combinationSum(new int[]{2, 3, 5}, 8));
    }

}
