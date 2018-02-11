package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * Created by limeng on 18-2-9.
 */
public class LongestPalindromicSubstring {
    /**
     * 动态规划
     * time over limit
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        long start = System.currentTimeMillis();
        System.out.println(longestPalindromicSubstring.longestPalindrome("abb"));
        System.out.println(start - System.currentTimeMillis());
    }


}
