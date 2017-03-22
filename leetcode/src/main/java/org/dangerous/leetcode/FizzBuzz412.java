package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fizz-buzz
 * Created by Administrator on 2017/3/22.
 */
public class FizzBuzz412 {
    /**15的倍数输出FizzBuzz
     * 3的倍数输出Fizz
     * 5的倍数输出Buzz
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FizzBuzz412 fb = new FizzBuzz412();
        List<String> result = fb.fizzBuzz(15);
        System.out.println(result.toString());
    }
}
