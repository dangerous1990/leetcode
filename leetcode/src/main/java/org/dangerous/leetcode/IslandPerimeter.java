package org.dangerous.leetcode;

/**
 * https://leetcode.com/problems/island-perimeter/description/
 * Created by limeng on 17-11-29.
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    sum += 4;
                    //判断上下左右是否挨着在1的方块,存在长度-1
                    if (i != 0 && grid[i - 1][j] == 1) {
                        sum -= 1;
                    }
                    if (i != grid.length - 1 && grid[i + 1][j] == 1) {
                        sum -= 1;
                    }
                    if (j != grid[i].length - 1 && grid[i][j + 1] == 1) {
                        sum -= 1;
                    }
                    if (j != 0 && grid[i][j - 1] == 1) {
                        sum -= 1;
                    }
                }

            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        System.out.println(islandPerimeter.islandPerimeter(grid));
    }
}
