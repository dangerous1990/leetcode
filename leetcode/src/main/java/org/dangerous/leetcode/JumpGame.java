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
     * 递归
     * @param index
     * @param nums
     * @param visited
     * @return
     */
    public boolean jump(int index, int[] nums, boolean[] visited) {
        for (int i = nums[index]; i > 0; i--) {
            if (index + i >= nums.length - 1) {
                return true;
            }
            if (visited[index + i]) {
                continue;
            }
            visited[index] = true;
            if (nums[index] == 0) {
                continue;
            }
            if (jump(index + i, nums, visited)) {
                return true;
            }
        }
        return false;
    }

//    public void iter(int[] nums, boolean[] visited){
//        for(int i =0;i <nums.length; ){
//            for (int i = nums[index]; i > 0; i--) {
//                if (index + i >= nums.length - 1) {
//                    return true;
//                }
//                if (visited[index + i]) {
//                    continue;
//                }
//                visited[index] = true;
//                if (nums[index] == 0) {
//                    continue;
//                }
//                if (jump(index + i, nums, visited)) {
//                    return true;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4})); // true
        System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4})); // false
        System.out.println(new JumpGame().canJump(new int[]{2, 0})); // true
        System.out.println(new JumpGame().canJump(new int[]{2, 5, 0, 0})); // true
        System.out.println(new JumpGame().canJump(new int[]{0})); // true
    }
}
