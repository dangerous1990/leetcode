package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/hamming-distance/
 * Created by Administrator on 2017/1/23.
 */
public class HammingDistance461 {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            if ((x&1) != (y&1)) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingDistance461 _461 = new HammingDistance461();
        int count = _461.hammingDistance(1, 4);
        System.out.println(count);
    }
}
