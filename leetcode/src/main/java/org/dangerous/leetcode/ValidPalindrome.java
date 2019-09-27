package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; ) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            while (!((a >= '0' && a <= '9') || (a >= 'a' && a <= 'z'))) {
                i = i + 1;
                if (i >= j) {
                    break;
                }
                a = s.charAt(i);
            }
            while (!((b >= '0' && b <= '9') || (b >= 'a' && b <= 'z'))) {
                j = j - 1;
                if (i >= j) {
                    break;
                }
                b = s.charAt(j);
            }
            if (i >= j) {
                return true;
            }
            if (a != b) {
                return false;
            }
            j--;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome(".,"));
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
    }
}
