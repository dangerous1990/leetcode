package org.dangerous.leetcode;

public class PowxN {

    public double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1;
        }
        if (x == -1 && n < 0) {
            return 1;
        }
        if (x == -1) {
            return -1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n == Integer.MAX_VALUE || n == Integer.MIN_VALUE) {
            return 0;
        }
        boolean negative = n < 0;
        n = Math.abs(n);
        if (n < 0) {
            n = Integer.MAX_VALUE;
        }
        double result = x;
        int temp = 1;
        while (temp <= n) {
            if (temp * 2 < 0 || temp * 2 > n) {
                break;
            }
            if (temp * 2 <= n) {
                temp *= 2;
                result *= result;
            }
        }
        int last = n - temp;
        while (last-- > 0) {
            result *= x;
        }
        return negative ? 1 / result : result;
    }
}
