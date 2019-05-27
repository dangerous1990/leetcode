package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int maxLength = strs[0].length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            char expect = strs[0].charAt(i);
            for (String s : strs) {
                if (i > s.length()) {
                    return sb.toString();
                }
                if (expect != s.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(expect);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
