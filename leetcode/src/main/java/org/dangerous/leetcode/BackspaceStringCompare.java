package org.dangerous.leetcode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        LinkedList<Character> s1 = new LinkedList<>();
        LinkedList<Character> t1 = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            } else {
                s1.push(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!t1.isEmpty()) {
                    t1.pop();
                }
            } else {
                t1.push(T.charAt(i));
            }
        }
        if (s1.size() != t1.size()) {
            return false;
        }
        while (!s1.isEmpty()) {
            if (s1.pop() != t1.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("ab#c", "ad#c"));
    }
}
