package org.dangerous.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>(9);
            Set<Character> columnSet = new HashSet<>(9);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                } else {
                    rowSet.add(board[i][j]);
                }
                if (board[j][i] != '.' && columnSet.contains(board[j][i])) {
                    return false;
                } else {
                    columnSet.add(board[j][i]);
                }
                if (i % 3 == 1 && j % 3 == 1 && !validSubBox(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validSubBox(int i, int j, char[][] board) {
        Set<Character> set = new HashSet<>(9);
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (board[k + i - 1][l + j - 1] != '.' && set.contains(board[k + i - 1][l + j - 1])) {
                    return false;
                } else {
                    set.add(board[k + i - 1][l + j - 1]);
                }
            }
        }
        return true;
    }
}
