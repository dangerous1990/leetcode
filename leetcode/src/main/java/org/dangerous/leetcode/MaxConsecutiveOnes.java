package org.dangerous.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/max-consecutive-ones/description/
 * Created by limeng on 17-12-4.
 */
public class MaxConsecutiveOnes {
    /**
     * 遍历元素，碰到0，计算前面的连续出现1的个数
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, stack.size());
                stack.clear();
            } else {
                stack.push(nums[i]);
            }
        }
        return Math.max(max, stack.size());
    }

    /**
     * 在上面的基础上优化，不使用栈计数，使用变量计数
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes2(int[] nums) {
        int count = 0;
        int max = 0;
        int half = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, count);
                if (max > half) {
                    return max;
                }
                count = 0;
            } else {
                count++;
            }
        }
        return Math.max(max, count);
    }
}
