package org.dangerous.leetcode.dp;

/**
 * https://leetcode.com/problems/fibonacci-number/submissions/
 */
public class FibonacciNumber {

    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[N];
    }

    public int fib2(int N) {
        if (N < 2) {
            return N;
        }
        int f = 0;
        int s = 1;
        int r = 0;
        int n = 2;
        while (n <= N) {
            r = f + s;
            f = s;
            s = r;
            n++;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().fib2(2));
        System.out.println(new FibonacciNumber().fib2(3));
        System.out.println(new FibonacciNumber().fib2(4));
    }
}
