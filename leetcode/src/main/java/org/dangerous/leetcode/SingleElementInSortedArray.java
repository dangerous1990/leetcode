package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 * Created by limeng on 17-12-1.
 */
public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            //判断当前元素和后一个元素是否相等,相等跳过下一元素
            if (nums[i] == nums[i + 1]) {
                i++;
            } else {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
