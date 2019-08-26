package org.dangerous.leetcode.backtracking;

/**
 * https://leetcode.com/problems/n-queens-ii/
 */
public class NQueensII {

    private int count;

    public int totalNQueens(int n) {
        backtrack(new char[n][n], 0);
        return count;
    }

    public void backtrack(char[][] grid, int row) {
        if (row == grid.length) {
            count++;
            return;
        }

        for (int i = 0; i < grid.length; i++) {
            grid[row][i] = 'Q';
            if (isValid(grid, row, i)) {
                backtrack(grid, row + 1);
            }
            grid[row][i] = '.';
        }

    }

    public boolean isValid(char[][] grid, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 'Q' && (Math.abs(row - i) == Math.abs(col - j) || j == col)) {
                    return false;
                }
            }
        }
        return true;
    }
}
