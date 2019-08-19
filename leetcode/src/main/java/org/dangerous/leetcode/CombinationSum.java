package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int[][] metrics = new int[target][candidates.length];
        for (int i = 0; i < candidates.length; i++) {
            for (int j = 0; j < target; j++) {
                metrics[j][i] = candidates[i];
            }
        }
        backtrace(new ArrayList<>(), 0, metrics, target, 0);
        return result;
    }

    public void backtrace(List<Integer> x, int index, int[][] metrics, int target, int flag) {
        int sum = x.stream().reduce(0, (a, b) -> a + b);
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(x));
            return;
        }
        if (metrics.length == x.size()) {
            return;
        }

        for (int i = flag; i < metrics[index].length; i++) {
            x.add(metrics[index][i]);
            backtrace(x, index + 1, metrics, target, i);
            x.remove(x.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum s = new CombinationSum();
        System.out.println(s.combinationSum(new int[]{2, 3, 5}, 8));
    }

}
