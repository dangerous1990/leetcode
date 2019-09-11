package org.dangerous.leetcode.dp;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // i or j ==0 only one path
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                // f(i,j) = sum (f(i-1,j),f(i,j-1)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 2));
    }
}
