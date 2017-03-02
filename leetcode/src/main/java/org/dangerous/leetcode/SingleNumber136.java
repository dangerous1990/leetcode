package org.dangerous.leetcode;

/**
 * Created by Administrator on 2017/2/6.
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int x = nums[0];
        if(nums.length<=1){
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            x^=nums[i];
        }
        return x;
    }
}
