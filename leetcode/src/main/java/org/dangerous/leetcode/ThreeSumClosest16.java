package org.dangerous.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2] - target;
        if (result == 0) {
            return target;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k] + nums[i];
                int value = sum - target;
                result = Math.abs(value) < Math.abs(result) ? value : result;
                if (value == 0) {
                    return target;
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result + target;
    }

}
