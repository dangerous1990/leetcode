package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/first-missing-positive/
 */
public class FindMissingPositive {
    /**
     * 利用数组做map O(n) time space O(n)
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int seq[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i] <= nums.length) {
                seq[nums[i]] = 1;
            }
        }
        for (int i = 0; i < seq.length; i++) {
            if (i > 0 && seq[i] == 0) {
                return i;
            }
        }
        return seq.length;
    }

    public static void main(String[] args) {
        FindMissingPositive test = new FindMissingPositive();
        System.out.println(test.firstMissingPositive(new int[]{1, 1})); // 2
        System.out.println(test.firstMissingPositive(new int[]{1, 2, 0}));// 3
        System.out.println(test.firstMissingPositive(new int[]{1}));// 2
        System.out.println(test.firstMissingPositive(new int[]{2}));// 1
        System.out.println(test.firstMissingPositive(new int[]{1, 2, 3}));// 4
        System.out.println(test.firstMissingPositive(new int[]{3, 4, -1, 1}));// 2
        System.out.println(test.firstMissingPositive(new int[]{7, 8, 9, 10, 11, 12}));// 1
    }
}
