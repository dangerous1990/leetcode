package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/binary-number-with-alternating-bits/description/
 * Created by limeng on 17-12-1.
 */
public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int front = n & 1;
        //右移一位
        n = n >> 1;
        while (n > 0) {
            //当前值与前一位是否相等
            if ((n & 1) == front) {
                return false;
            } else {
                front = n & 1;
                n = n >> 1;
            }
        }
        return true;
    }
}
