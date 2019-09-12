package org.dangerous.leetcode.dp;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                // obstacles is no way
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                // i or j ==0 previous path
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                // f(i,j) = sum (f(i-1,j),f(i,j-1)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
//                {1, 0, 0}
        }));
    }
}
