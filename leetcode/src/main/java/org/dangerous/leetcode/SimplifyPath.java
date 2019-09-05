package org.dangerous.leetcode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (String str : strs) {
            if (str.equals("") || str.equals(".")) {
                continue;
            }
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(str);
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder("/");
        for (int i = stack.size() - 1; i >= 0; i--) {
            sb.append(stack.get(i));
            sb.append("/");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/a//b////c/d//././/.."));
    }
}
