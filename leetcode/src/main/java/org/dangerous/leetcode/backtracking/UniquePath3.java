package org.dangerous.leetcode.backtracking;

public class UniquePath3 {

    private int zeroCount;
    private int resultCount;

    public int uniquePathsIII(int[][] grid) {
        int row = 0, col = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                }
                if (grid[i][j] == 0) {
                    zeroCount++;
                }
            }
        }
        dfs(grid, row, col, new boolean[grid.length][grid[0].length], 0);
        return resultCount;
    }

    public void dfs(int[][] grid, int row, int col, boolean[][] visited, int count) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[row].length && grid[row][col] == 2 && count == zeroCount + 1) {
            resultCount++;
            return;

        }
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[row].length) {
            if (visited[row][col] || grid[row][col] == -1 || grid[row][col] == 2) {
                return;
            }
            visited[row][col] = true;
            count++;
            dfs(grid, row, col + 1, visited, count); // right
            dfs(grid, row, col - 1, visited, count); // left
            dfs(grid, row - 1, col, visited, count); // top
            dfs(grid, row + 1, col, visited, count); // bottom
            count--;
            visited[row][col] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new UniquePath3().uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
        System.out.println(new UniquePath3().uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}));
        System.out.println(new UniquePath3().uniquePathsIII(new int[][]{{0, 1}, {2, 0}}));
        System.out.println(new UniquePath3().uniquePathsIII(new int[][]{{1, 2}}));
    }
}
