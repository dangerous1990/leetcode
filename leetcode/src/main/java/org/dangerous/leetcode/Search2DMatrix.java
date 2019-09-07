package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int n = -1;
        // 确定target在哪一行的范围内
        for (int i = 0, j = 1; j < matrix.length; i++, j++) {
            if (target == matrix[i][0] || target == matrix[j][0]) {
                return true;
            }
            if (target > matrix[i][0] && target < matrix[j][0]) {
                n = i;
                break;
            }
        }
        // 二分查找
        return binarySearch(matrix, target, n == -1 ? matrix.length - 1 : n);

    }


    private boolean binarySearch(int[][] matrix, int target, int n) {
        int low = 0;
        int high = matrix[n].length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target > matrix[n][mid]) {
                low = mid + 1;
            } else if (target < matrix[n][mid]) {
                high = mid - 1;
            } else if (target == matrix[n][mid]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(new Search2DMatrix().searchMatrix(matrix, 3));
        int[][] matrix2 = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(new Search2DMatrix().searchMatrix(matrix2, 13));
        System.out.println(new Search2DMatrix().searchMatrix(new int[][]{}, 1));
        System.out.println(new Search2DMatrix().searchMatrix(new int[][]{{1}}, 1));
    }
}
