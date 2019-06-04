package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class PowxN {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long absN = n;
        if (n < 0) {
            absN = -(long)n;
            x = 1 / x;
        }
        double ans = 1;
        while (absN > 0) {
            if ((absN & 1) == 1) ans *= x;
            x *= x;
            absN >>= 1;
        }
        return ans;
    }
}
