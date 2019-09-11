package org.dangerous.leetcode.dp;

/**
 * https://leetcode.com/problems/divisor-game/
 */
public class DivisorGame {
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        for (int i = 2; i <= N; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (i % j == 0) {
                    if (dp[i - j] == false) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(new DivisorGame().divisorGame(1));
        System.out.println(new DivisorGame().divisorGame(2));
        System.out.println(new DivisorGame().divisorGame(3));
        System.out.println(new DivisorGame().divisorGame(4));
        System.out.println(new DivisorGame().divisorGame(5));
        System.out.println(new DivisorGame().divisorGame(6));
        System.out.println(new DivisorGame().divisorGame(7));
        System.out.println(new DivisorGame().divisorGame(8));
        System.out.println(new DivisorGame().divisorGame(9));
        System.out.println(new DivisorGame().divisorGame(10));
        System.out.println(new DivisorGame().divisorGame(11));
    }
}
