package org.dangerous.leetcode;

import java.util.Arrays;
import java.util.List;

public class Integer2Roman {

    private List<pair> list = Arrays.asList(
            new pair(1, "I"),
            new pair(5, "V"),
            new pair(10, "X"),
            new pair(50, "L"),
            new pair(100, "C"),
            new pair(500, "D"),
            new pair(1000, "M")
    );

    class pair {
        int value;
        String c;

        pair(int value, String c) {
            this.value = value;
            this.c = c;
        }
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        helper(num, list.size() - 1, sb);
        return sb.toString();
    }

    private int getCarry(int num) {
        if (num > 0 && num < 10) {
            return 1;
        }
        if (num >= 10 && num < 100) {
            return 10;
        }
        if (num >= 100 && num < 1000) {
            return 100;
        }
        if (num >= 1000) {
            return 1000;
        }
        return 0;
    }

    private int helper(int num, int index, StringBuilder sb) {
        if (index < 0) {
            return 0;
        }
        if (num == 0) {
            return 0;
        }
        int carry = list.get(index).value;
        if (num < list.get(index).value) {
            return helper(num, --index, sb);
        }
        // 取第一个数字，如果数字为4，9，需要特殊处理
        int digit = num / getCarry(num);
        if (digit == 4) {
            sb.append(list.get(index).c);
            sb.append(list.get(index + 1).c);
            return helper(num % getCarry(num), --index, sb);
        }
        if (digit == 9) {
            sb.append(list.get(index - 1).c);
            sb.append(list.get(index + 1).c);
            return helper(num % getCarry(num), --index, sb);
        }
        //
        digit = num / carry;
        while (digit != 0) {
            sb.append(list.get(index).c);
            digit--;
        }
        return helper(num % carry, --index, sb);
    }

    public static void main(String[] args) {
        System.out.println(new Integer2Roman().intToRoman(9));
        System.out.println(new Integer2Roman().intToRoman(1));
        System.out.println(new Integer2Roman().intToRoman(2));
        System.out.println(new Integer2Roman().intToRoman(2));
        System.out.println(new Integer2Roman().intToRoman(4));
        System.out.println(new Integer2Roman().intToRoman(11));
        System.out.println(new Integer2Roman().intToRoman(15));
        System.out.println(new Integer2Roman().intToRoman(19));
        System.out.println(new Integer2Roman().intToRoman(20));
        System.out.println(new Integer2Roman().intToRoman(25));
        System.out.println(new Integer2Roman().intToRoman(29));
        System.out.println(new Integer2Roman().intToRoman(101));
    }
}
