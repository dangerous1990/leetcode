package org.dangerous;

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        // https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52371/My-one-line-solutions-in-3-languages
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
