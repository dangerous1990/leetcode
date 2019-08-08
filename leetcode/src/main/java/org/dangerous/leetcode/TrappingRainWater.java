package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/trapping-rain-water/submissions/
 */
public class TrappingRainWater {


    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int left = 0;
        int right = height.length - 2;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int water = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                water += (leftMax - height[left]);
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += (rightMax - height[right]);
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater c = new TrappingRainWater();
        c.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        c.trap(new int[]{4, 2, 3});
    }
}
