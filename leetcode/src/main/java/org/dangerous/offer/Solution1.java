package org.dangerous.offer;

/**
 * Created by limeng on 18-7-3.
 */
public class Solution1 {
    public boolean Find(int target, int[][] array) {
        if (array[0].length == 0) {
            return false;
        }
        for (int i = 0; i < array[0].length - 1; i++) {
            if (search(target, array[i], 0, array[i].length - 1) != -1) {
                return true;
            }
        }
        return false;
    }

    public int search(int target, int[] array, int low, int high) {
        int mid = (low + high) / 2;

        if (array[mid] == target) {
            return mid;
        }
        if (low == high) {
            return -1;
        }
        if (target < array[mid]) {
            return search(target, array, low, mid);
        }
        if (target > array[mid]) {
            return search(target, array, mid + 1, high);
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1 Solution1 = new Solution1();
//        boolean re = Solution1.Find(1,new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}});
        System.out.println(Solution1.search(15, new int[]{6, 8, 11, 15}, 0, 3));
    }
}
