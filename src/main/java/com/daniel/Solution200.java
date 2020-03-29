package com.daniel;

/**
 * @author Daniel Xia
 * @since 2019-07-06 15:05
 */
public class Solution200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    infect(grid, i, n, j, m);
                }
            }
        }

        return res;
    }

    private void infect(char[][] grid, int i, int n, int j, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';
        infect(grid, i + 1, n, j, m);
        infect(grid, i - 1, n, j, m);
        infect(grid, i, n, j + 1, m);
        infect(grid, i, n, j - 1, m);

    }


}
