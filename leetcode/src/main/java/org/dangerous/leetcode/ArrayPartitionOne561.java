package org.dangerous.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/description/
 * 先排序
 * 以2为长度将入参切成n个数组，取每个数组的最小值相加
 * Created by limeng on 17-11-28.
 */
public class ArrayPartitionOne561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
