package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/toeplitz-matrix/description/
 * Created by limeng on 18-2-8.
 */
public class ToeplitzMatrix {
    /**
     * 横向遍历 对角线查询 x+1 y+1
     * 纵向遍历 对角线查询 x+1 y+1
     *
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int height = matrix.length;
        int length = matrix[0].length;
        for (int i = 0; i < length; i++) {
            int v = matrix[0][i];
            int x = 1;
            int y = i + 1;
            while (x < height && y < length) {
                if (v != matrix[x][y]) {
                    return false;
                } else {
                    x = x + 1;
                    y = y + 1;
                }
            }
        }
        for (int i = 0; i < height; i++) {
            int v = matrix[i][0];
            int x = i + 1;
            int y = 1;
            while (x < height && y < length) {
                if (v != matrix[x][y]) {
                    return false;
                } else {
                    x = x + 1;
                    y = y + 1;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        int[][] matrixa = {{1, 2}, {2, 2}};
        int[][] matrixb = {{36, 59, 71, 15, 26, 82, 87}, {56, 36, 59, 71, 15, 26, 82}, {15, 0, 36, 59, 71, 15, 26}};
        ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();
        System.out.println(toeplitzMatrix.isToeplitzMatrix(matrix));
        System.out.println(toeplitzMatrix.isToeplitzMatrix(matrixb));
    }
}
