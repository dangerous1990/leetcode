package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/self-dividing-numbers/description/
 * Created by limeng on 17-11-27.
 */
public class SelfDividingNumbers728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int subnum = i;
            int num = i % 10;
            boolean isDivide = false;
            while (subnum > 0) {
                if (num == 0 || i % num != 0) {
                    isDivide = false;
                    break;
                } else {
                    isDivide = true;
                }
                subnum = subnum / 10;
                num = subnum % 10;
            }
            if (isDivide) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SelfDividingNumbers728 selfDividingNumbers728 = new SelfDividingNumbers728();
        List<Integer> result = selfDividingNumbers728.selfDividingNumbers(1, 22);
        System.out.println(result.toString());

    }
}
