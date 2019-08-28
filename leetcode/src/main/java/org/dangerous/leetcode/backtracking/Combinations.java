package org.dangerous.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(k), 0, k, n, 0);
        return res;
    }


    public void backtrack(List<List<Integer>> res, List<Integer> comb, int index, int k, int n, int prevIndex) {
        if (index > k) {
            return;
        }
        if (index == k) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = prevIndex; i < n; i++) {
            comb.add(i + 1);
            backtrack(res, comb, index + 1, k, n, i + 1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));

    }
}
