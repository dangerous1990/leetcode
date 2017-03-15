package org.dangerous.leetcode;

/**
 * Created by Administrator on 2017/3/3.
 */
public class ValidPerfectSquare367 {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        ValidPerfectSquare367 vps = new ValidPerfectSquare367();
        System.out.println(vps.isPerfectSquare(2147483647));
        System.out.println(vps.isPerfectSquare(14));
    }
}
