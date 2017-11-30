package org.dangerous.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-greater-element-i/description/
 * 题意 nums1 是nums2的子集，在nums2找出nums1元素的索引，已沿着索引继续搜索比元素大的第一个值返回，没有返回 -1
 * Created by limeng on 17-11-30.
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = indexOf(nums2, nums1[i]);
        }
        return result;
    }

    private int indexOf(int[] nums2, int value) {
        int index = -1;
        for (int i = 0; i < nums2.length; i++) {
            if (value == nums2[i]) {
                index = i;
                continue;
            }
            if (index > -1 && nums2[i] > value) {
                return nums2[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(new NextGreaterElementI().nextGreaterElement(nums1, nums2)));
    }

}
