package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/complement-of-base-10-integer
 */
public class ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int n = 0;
        for (int i = 0; i < 32; i++) {
            if (N != 0) {
                if ((N & 1) == 0) {
                    n = n | 1 << i;
                }
                N = N >> 1;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new ComplementOfBase10Integer().bitwiseComplement(5));
        System.out.println(new ComplementOfBase10Integer().bitwiseComplement(7));
        System.out.println(new ComplementOfBase10Integer().bitwiseComplement(10));
    }
}
