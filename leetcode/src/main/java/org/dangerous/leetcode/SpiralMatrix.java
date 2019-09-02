package org.dangerous.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        int length = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>(length);
        dfs(0, 0, matrix, 0, res, new boolean[matrix.length][matrix[0].length], length);
        return res;
    }

    // right down left up
    int[][] direct = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void dfs(int row, int col, int[][] matrix, int count, List<Integer> res, boolean[][] visited, int length) {
        res.add(matrix[row][col]);
        visited[row][col] = true;
        if (res.size() == length) {
            return;
        }
        int nextRow = row + direct[count % 4][0];
        int nextCol = col + direct[count % 4][1];
        // check is valid
        while (!check(nextRow, nextCol, matrix, visited)) {
            count++;// turn direction
            nextRow = row + direct[count % 4][0];
            nextCol = col + direct[count % 4][1];
        }
        dfs(nextRow, nextCol, matrix, count, res, visited, length);
    }

    private boolean check(int row, int col, int[][] matrix, boolean[][] visited) {
        if (row < 0 | col < 0) {
            return false;
        }

        if (row >= matrix.length) {
            return false;
        }

        if (col >= matrix[row].length) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }));
    }
}
