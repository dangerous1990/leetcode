package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        dfs(0, 0, matrix, 0, n * n, 1);
        return matrix;
    }

    // right down left up
    int[][] direct = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void dfs(int row, int col, int[][] matrix, int d, int length, int num) {
        matrix[row][col] = num++;
        if (num == length + 1) {
            return;
        }
        int nextRow = row + direct[d % 4][0];
        int nextCol = col + direct[d % 4][1];
        // check is valid
        while (!check(nextRow, nextCol, matrix)) {
            d++;// turn direction
            nextRow = row + direct[d % 4][0];
            nextCol = col + direct[d % 4][1];
        }
        dfs(nextRow, nextCol, matrix, d, length, num++);
    }

    private boolean check(int row, int col, int[][] matrix) {
        if (row < 0 | col < 0) {
            return false;
        }

        if (row >= matrix.length) {
            return false;
        }

        if (col >= matrix[row].length) {
            return false;
        }
        if (matrix[row][col] != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrixII().generateMatrix(3)[0][0]);
    }
}
