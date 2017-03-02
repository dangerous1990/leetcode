package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 * x + y = target;
 * y = target - x ;
 * 在数组中二分查找y的值
 * 二分查找7ms（beats 8%）
 * Created by Administrator on 2017/3/2.
 */
public class TwoSum2167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int index = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (index != -1) {
                return new int[]{i + 1, index + 1};
            }
        }
        return new int[]{};
    }

    private int binarySearch(int[] array, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                low = mid + 1;
            }
            if (array[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }

}
