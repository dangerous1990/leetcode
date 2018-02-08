package org.dangerous.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by limeng on 17-12-26.
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 4, 5);
        int result = a.stream().reduce((integer, integer2) -> integer+integer2).get();
        System.out.println(result);
//        a.stream().reduce()
    }
}
