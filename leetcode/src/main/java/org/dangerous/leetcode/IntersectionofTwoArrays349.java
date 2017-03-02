package org.dangerous.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/2.
 */
public class IntersectionofTwoArrays349 {
    /**
     * 排序一个数组
     * 遍历另一个数组去排序的数组中进行查找
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums1;
        }
        if (nums2.length == 0) {
            return nums2;
        }
        Set<Integer> set = new HashSet<Integer>();
        Arrays.sort(nums1);
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                continue;
            }
            int index = Arrays.binarySearch(nums1, nums2[i]);
            if (index >= 0) {
                set.add(nums2[i]);
            }
        }
        if (set.isEmpty()) {
            return new int[]{};
        }
        Integer[] array = set.toArray(new Integer[]{});
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
}
