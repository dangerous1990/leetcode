package org.dangerous.leetcode.dp;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        // length of coins
        int n = coins.length;

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if ((i - coins[j]) >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }
}
