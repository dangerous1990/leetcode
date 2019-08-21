package org.dangerous.leetcode.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/generate-parentheses
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrace(n * 2, 0, "()", result, new StringBuilder(), new LinkedList<>(), new HashMap<>());
        return result;
    }


    public void backtrace(int size, int index, String pair, List<String> result, StringBuilder path, LinkedList<Character> stack, Map<Character, Integer> count) {
        if (index == size) {
            if (stack.isEmpty()) {
                result.add(path.toString());
            }
            return;
        }
        for (int i = 0; i < pair.length(); i++) {
            char c = pair.charAt(i);
            if (c == ')' && stack.isEmpty()) {
                return;
            }
            if (count.getOrDefault(c, 0) == size / 2) {
                continue;
            }
            if (c == '(') {
                stack.push('(');
            }
            LinkedList<Character> s = new LinkedList<>(stack);
            if (c == ')') {
                s.pop();
            }
            count.put(c, count.getOrDefault(c, 0) + 1);
            path.append(c);
            backtrace(size, index + 1, pair, result, path, s, count);
            count.put(c, count.get(c) - 1);
            if (c == '(') {
                stack.pop();
            }
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
