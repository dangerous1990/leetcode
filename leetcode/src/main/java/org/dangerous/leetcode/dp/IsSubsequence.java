package org.dangerous.leetcode.dp;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        int beginIndex = 0;
        for (int i = 0; i < sn; i++) {
            boolean found = false;
            for (int j = beginIndex; j < tn; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    found = true;
                    beginIndex = j + 1;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence("axc", "ahbgdc"));
    }
}
