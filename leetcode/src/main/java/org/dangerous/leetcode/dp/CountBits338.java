package org.dangerous.leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/counting-bits/
 * Created by Administrator on 2017/1/23.
 */
public class CountBits338 {
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountBits338().countBits(12)));
    }
}
