package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/reverse-string/
 * Created by Administrator on 2017/2/6.
 */
public class ReverseString344 {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
