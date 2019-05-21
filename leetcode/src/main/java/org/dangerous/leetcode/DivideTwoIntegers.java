package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        // 处理越界问题
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // 异或判断返回正数还是负数
        boolean isNeg = (dividend < 0) ^ (divisor < 0);
        // 都转成负数高位为1
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        return isNeg ? -div(dividend, divisor) : div(dividend, divisor);
    }

    public int div(int divid, int divis) {
        if (divid > divis) return 0;
        int curSum = divis << 1;
        int prevSum = divis;
        int q = 1;

        while (divid <= curSum && curSum < prevSum) {
            prevSum = curSum;
            curSum <<= 1; // x2
            q <<= 1; // x2
        }
        // divid - prevSum(已经被整除的部分)
        return q + div(divid - prevSum, divis);
    }
}
