package org.dangerous.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 * <p>
 * Created by limeng on 17-11-28.
 */
public class ReverseWordsInAStringIII557 {
    /**
     * 遍历字符串入栈，碰到空格，出栈,time limit
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            } else {
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    /**
     * 空格切分
     * 前后交换
     *
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            for (int j = 0, k = chars.length - 1; j < k; j++, k--) {
                char temp = chars[j];
                chars[j] = chars[k];
                chars[k] = temp;
            }
            sb.append(chars).append(' ');
        }
        return sb.toString().substring(0, s.length());
    }

}
