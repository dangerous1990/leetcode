package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class Integer2Roman {
    int[] keys = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] tokens = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        helper(num, keys.length - 1, sb);
        return sb.toString();
    }

    private void helper(int num, int index, StringBuilder sb) {
        if (index < 0) {
            return;
        }
        if (num == 0) {
            return;
        }
        int carry = keys[index];
        if (num < carry) {
            helper(num, --index, sb);
            return;
        }
        int digit = num / carry;
        while (digit != 0) {
            sb.append(tokens[index]);
            digit--;
        }
        helper(num % carry, --index, sb);
        return;
    }
}
