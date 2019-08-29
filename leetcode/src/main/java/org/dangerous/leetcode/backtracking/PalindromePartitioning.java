package org.dangerous.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(new ArrayList<>(s.length()), s, 0, result);
        return result;
    }


    public void backtrack(List<String> partitions, String s, int prevIndex, List<List<String>> result) {
        if (prevIndex == s.length()) {
            result.add(new ArrayList<>(partitions));
            return;
        }

        for (int i = prevIndex + 1; i <= s.length(); i++) {
            if (!isValidPalindrome(s, prevIndex, i)) {
                continue;
            }
            partitions.add(s.substring(prevIndex, i));
            backtrack(partitions, s, i, result);
            partitions.remove(partitions.size() - 1);
        }
    }

    public boolean isValidPalindrome(String str, int beginIndex, int endIndex) {
        for (int i = beginIndex, j = endIndex - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
        System.out.println(new PalindromePartitioning().partition("efe"));
        System.out.println(new PalindromePartitioning().partition("a"));
    }
}
