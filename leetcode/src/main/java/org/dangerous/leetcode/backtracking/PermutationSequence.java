package org.dangerous.leetcode.backtracking;

/**
 * https://leetcode.com/problems/permutation-sequence
 */
public class PermutationSequence {
    private String result;
    private int size;

    public String getPermutation(int n, int k) {
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = i + 1;
        }
        backtrace(new StringBuilder(n), 0, k, candidates, new int[n]);
        return result;
    }

    public void backtrace(StringBuilder sb, int index, int k, int[] candidates, int[] path) {
        if (size > k) {
            return;
        }
        if (index == candidates.length) {
            size++;
            if (k == size) {
                result = sb.toString();
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (path[i] == 1) {
                continue;
            }
            sb.append(candidates[i]);
            path[i] = 1;
            backtrace(sb, index + 1, k, candidates, path);
            sb.deleteCharAt(sb.length() - 1);
            path[i] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(3, 3));
        System.out.println(new PermutationSequence().getPermutation(3, 1));
        System.out.println(new PermutationSequence().getPermutation(4, 9));
    }
}
