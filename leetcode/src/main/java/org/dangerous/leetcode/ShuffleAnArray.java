package org.dangerous.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/shuffle-an-array
 */
public class ShuffleAnArray {

    private int[] nums;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] rand = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int r = (int) (Math.random() * (i + 1));
            rand[i] = rand[r];
            rand[r] = nums[i];
        }
        return rand;
    }

    public static void main(String[] args) {
        ShuffleAnArray s = new ShuffleAnArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.reset()));

    }
}
