package org.dangerous.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
    /**
     * x,y next swap location
     * n length of matrix
     * next y = n - 1 - prev x
     * next x = prev y
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int count = 0;
                int x = i;
                int y = j;
                int fly = matrix[i][j];
                // ->
                //    |
                // <-
                // need rotate three times
                while (count < 3) {
                    int tempy = n - 1 - x;
                    x = y;
                    y = tempy;
                    int temp = matrix[x][y];
                    matrix[x][y] = fly;
                    fly = temp;
                    count++;
                }
                matrix[i][j] = fly;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        new RotateImage().rotate(matrix);
        new RotateImage().rotate(matrix2);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        for (int i = 0; i < matrix2.length; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }
    }
}
