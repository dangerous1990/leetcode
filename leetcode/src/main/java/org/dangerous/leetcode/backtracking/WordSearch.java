package org.dangerous.leetcode.backtracking;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, new boolean[board.length][board[0].length], word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int col, boolean[][] visited, String word, int count) {
        if (count > word.length()) {
            return false;
        }
        if (count == word.length()) {
            return true;
        }
        if (row >= 0 && col >= 0 && row < board.length && col < board[row].length) {
            if (visited[row][col]) {
                return false;
            }
            if (board[row][col] != word.charAt(count)) {
                return false;
            }
            visited[row][col] = true;
            count++;
            if (dfs(board, row + 1, col, visited, word, count) ||
                    dfs(board, row - 1, col, visited, word, count) ||
                    dfs(board, row, col + 1, visited, word, count) ||
                    dfs(board, row, col - 1, visited, word, count)) {
                return true;
            }
            count--;
            visited[row][col] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new WordSearch().exist(board, "ABCCED"));
        System.out.println(new WordSearch().exist(board, "SEE"));
        System.out.println(new WordSearch().exist(board, "ABCB"));
    }
}
