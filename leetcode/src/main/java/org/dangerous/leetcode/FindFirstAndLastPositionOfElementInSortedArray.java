package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            }
        }
        if (index == -1) {
            return new int[]{-1, -1};
        }
        // search before
        int first = index;
        while (first >= 0) {
            if (nums[first] != target) {
                break;
            }
            if (nums[first] == target) {
                first--;
            }
        }
        // search after
        int last = index;
        while (last < nums.length) {
            if (nums[last] != target) {
                break;
            }
            if (nums[last] == target) {
                last++;
            }
        }
        return new int[]{first + 1 < nums.length ? first + 1 : nums.length - 1, last - 1 >= 0 ? last - 1 : 0};
    }
}
