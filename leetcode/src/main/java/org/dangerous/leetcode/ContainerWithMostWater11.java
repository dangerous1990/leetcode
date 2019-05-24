package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater11 {
    /**
     *  穷举步长step 231ms
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int step = 1;
        int max = 0;
        while (step < height.length) {
            for (int i = 0, j = step; i < height.length && j < height.length; i++, j = i + step) {
                max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            }
            step++;
        }
        return max;
    }

    /**
     *  height[lo] <= min 如果高度小于最低值，面积一定小于当前的最大值，跳过计算
     *  1ms
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int max = 0;
        while (lo < hi) {
            int min = Math.min(height[lo], height[hi]);
            max = Math.max(max, min * (hi - lo));
            while (lo <= hi && height[lo] <= min) lo++;
            while (lo <= hi && height[hi] <= min) hi--;
        }
        return max;
    }
}
