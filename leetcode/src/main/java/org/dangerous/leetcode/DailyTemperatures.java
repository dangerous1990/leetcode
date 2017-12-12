package org.dangerous.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/daily-temperatures/description/
 * Created by limeng on 17-12-12.
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int count = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] - temperatures[i] > 0) {
                    result[i] = count + 1;
                    break;
                }
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(new int[]{55, 38, 53, 81, 61, 93, 97, 32, 43, 78})));
    }
}
