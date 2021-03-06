package org.dangerous.leetcode.backtracking;

/**
 * https://leetcode.com/problems/beautiful-arrangement/
 */
public class BeautifulArrangement {
    private int count;

    public int countArrangement(int N) {
        backtrack(0, N,  0);
        return count;
    }

    public void backtrack(int index, int N, int path) {
        if (N == index) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            int pos = 1 << i;
            if ((path & pos) > 0) {
                continue;
            }
            int ith = i + 1;
            int ix = index + 1;
            if (ix % ith == 0 || ith % ix == 0) {
                path = path | pos;
                backtrack(index + 1, N, path);
                path = path ^ pos;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new BeautifulArrangement().countArrangement(3));
        System.out.println(new BeautifulArrangement().countArrangement(2));
    }
}
