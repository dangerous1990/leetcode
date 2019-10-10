package org.dangerous.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            int a = 0, b = 0;
            switch (tokens[i]) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b + a);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.valueOf(tokens[i]));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
