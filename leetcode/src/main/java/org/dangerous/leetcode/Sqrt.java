package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/sqrtx
 */
public class Sqrt {

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        // 计算x是2的多少倍
        int multiple = 0;
        int temp = x;
        while (temp != 0) {
            temp = temp >> 1;
            if (temp != 0) {
                multiple++;
            }
        }
        // 倍数开方
        int begin = 0;
        int end = 0;
        for (int slow = 0, fast = 1; fast < 32; fast++, slow++) {
            if (multiple >= slow << 1 && multiple <= fast << 1) {
                begin = 1 << slow;
                end = 1 << fast;
            }
        }
        // 缩小查询的位置
        for (int slow = begin, fast = begin + 1; fast <= end; fast++, slow++) {
            long square = (long) fast * (long) fast;// 解决越界问题
            if (x >= slow * slow && x <= square) {
                return x == square ? fast : slow;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(2));
        System.out.println(new Sqrt().mySqrt(3));
        System.out.println(new Sqrt().mySqrt(5));
        System.out.println(new Sqrt().mySqrt(9));
        System.out.println(new Sqrt().mySqrt(16));
        System.out.println(new Sqrt().mySqrt(24));
        System.out.println(new Sqrt().mySqrt(25));
        System.out.println(new Sqrt().mySqrt(2147395599));
        System.out.println(new Sqrt().mySqrt(2147483647));
    }
}
