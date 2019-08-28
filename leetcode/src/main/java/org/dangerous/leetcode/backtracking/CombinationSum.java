package org.dangerous.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public void backtrack(List<Integer> path, int[] candidates, int target, int prevIndex) {
        if (target < 0) {
            return;
        }
        if (0 == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = prevIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            path.add(candidates[i]);
            backtrack(path, candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum s = new CombinationSum();
        System.out.println(s.combinationSum(new int[]{2, 3, 5}, 8));
    }

}
