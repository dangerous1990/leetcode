package org.dangerous.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) { return res; }
        // build chessboard @mat(=matrix)
        char[][] mat = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = '.';
            }
        }
        backtrack(mat, 0, res);
        return res;
    }

    public void backtrack(char[][] grid, int row, List<List<String>> res) {
        if (row == grid.length) {
            res.add(builder(grid));
            return;
        }

        for (int i = 0; i < grid.length; i++) {
            grid[row][i] = 'Q';
            if (isValid(grid, row, i)) {
                backtrack(grid, row + 1, res);
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


    private List<String> builder(char[][] mat) {
        List<String> tmp = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            tmp.add(new String(mat[i]));
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}
