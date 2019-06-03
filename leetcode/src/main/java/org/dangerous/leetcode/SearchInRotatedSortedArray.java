package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int num = nums[mid];
            //nums [ mid ] 和 target 在同一段
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                num = nums[mid];
                //nums [ mid ] 和 target 不在同一段，同时还要考虑下变成 -inf 还是 inf。
            } else {
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (num < target)
                lo = mid + 1;
            else if (num > target)
                hi = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
