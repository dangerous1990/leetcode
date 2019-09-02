package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length == 1 && nums[0] == 0) {
            return true;
        }
        return jump(0, nums, new boolean[nums.length]);
    }

    /**
     * dfs
     *
     * @param index
     * @param nums
     * @param visited
     * @return
     */
    public boolean jump(int index, int[] nums, boolean[] visited) {
        for (int i = nums[index]; i > 0; i--) {
            int pos = index + i;
            if (pos >= nums.length - 1) {
                return true;
            }
            if (visited[pos]) {
                continue;
            }
            visited[pos] = true;
            if (nums[pos] == 0) {
                continue;
            }
            if (jump(pos, nums, visited)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4})); // true
        System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4})); // false
        System.out.println(new JumpGame().canJump(new int[]{2, 0})); // true
        System.out.println(new JumpGame().canJump(new int[]{2, 5, 0, 0})); // true
        System.out.println(new JumpGame().canJump(new int[]{0})); // true
    }
}
