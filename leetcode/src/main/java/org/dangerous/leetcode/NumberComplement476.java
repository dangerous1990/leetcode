package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/number-complement/
 * Created by Administrator on 2017/1/23.
 */
public class NumberComplement476 {
    public int findComplement(int num) {
        return ~num + (Integer.highestOneBit(num) << 1);
    }

    public static void main(String[] args) {
        NumberComplement476 _476 = new NumberComplement476();
        System.out.println(_476.findComplement(5));
    }
}
