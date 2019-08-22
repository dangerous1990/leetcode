package org.dangerous.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, n, result, new StringBuilder());
        return result;
    }


    public void backtrack(int left, int right, List<String> result, StringBuilder path) {
        if (left == 0 && right == 0) {
            result.add(path.toString());
            return;
        }
        if (left > 0) {
            path.append("(");
            backtrack(left - 1, right, result, path);
            path.deleteCharAt(path.length() - 1);
        }
        if (right > left) {
            path.append(")");
            backtrack(left, right - 1, result, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
