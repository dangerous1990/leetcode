package org.dangerous.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    private Map<Character, Character> left = new HashMap<>(3);
    private Map<Character, Character> right = new HashMap<>(3);

    {
        left.put('{', '}');
        left.put('[', ']');
        left.put('(', ')');

        right.put('}', '{');
        right.put(']', '[');
        right.put(')', '(');
    }

    /**
     * 栈
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character x = s.charAt(i);
            if (left.containsKey(x)) {
                stack.push(x);
            }
            if (right.containsKey(x)) {
                if (stack.size() == 0) {
                    return false;
                }
                if (!(stack.pop().equals(right.get(x)))) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
