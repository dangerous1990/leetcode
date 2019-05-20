package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * solution https://leetcode.com/problems/zigzag-conversion/discuss/295830/share-java-solution-40ms-Memory-99
 */
public class ZigZagConversion6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < numRows; i++) {
            for (int j = i, k = 0; j < s.length(); j += 2, k++) {
                if (k % (numRows - 1) == 0) {
                    sb.append(s.charAt(j));
                    continue;
                }
                if ((i + k) % (numRows - 1) == 0) {
                    sb.append(s.charAt(j));
                    continue;
                }
            }
        }
        return sb.toString();
    }
}