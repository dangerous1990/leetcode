package org.dangerous.leetcode.backtracking;

/**
 * https://leetcode.com/problems/beautiful-arrangement/
 */
public class BeautifulArrangement {
    private int count;

    public int countArrangement(int N) {
        backtrack(0, N, 0, 0);
        return count;
    }

    public void backtrack(int index, int N, int arrayCount, int path) {
        if (N == index) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            int pos = 1 << i;
            int b = (path & pos) >> i;
            if (b == 1) {
                continue;
            }
            int ith = i + 1;
            int ix = arrayCount + 1;
            if (ix % ith == 0 || ith % ix == 0) {
                arrayCount++;
                path = path | pos;
                backtrack(index + 1, N, arrayCount, path);
                arrayCount--;
                path = path ^ pos;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new BeautifulArrangement().countArrangement(3));
    }
}
