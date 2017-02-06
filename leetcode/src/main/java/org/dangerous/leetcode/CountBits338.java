package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/counting-bits/
 * Created by Administrator on 2017/1/23.
 */
public class CountBits338 {
    public int[] countBits(int num) {
        int result[] = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            int count = 0;
            while (j > 0) {
                if ((j & 1) == 1) {
                    count++;
                }
                j >>= 1;
            }
            result[i] = count;
        }
        return result;
    }
}
