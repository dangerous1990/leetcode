package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
 */
public class FindAllNumbersDisappearedInAnArray {
    /**
     * n=nums.length
     * 元素范围 1<=nums[i]<=n
     * 把原来的nums作为map
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // disappeared num do not change
            // appeared num change to n + num/%n
            // %n because of num can appear twice
            nums[(nums[i] - 1) % n] += n;
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
