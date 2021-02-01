/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-02-01 21:48:15
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-02-01 22:08:46
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res++;
                    dfs(grid, m, n, i, j);
                }
            }
        }
        return res;
    }

    int[][] direction = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    private void dfs(int[][] grid, int m, int n, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 说明过边界了
            return;
        }
        // 0 为 海洋， 1 为陆地， 2 表示已经遍历过
        if (grid[i][j] != 1) {
            return;
        }
        // 至此，说明为 1，将其标示为已经遍历
        grid[i][j] = 2;

        for (int[] d : direction) {
            // 四个方向进行 BFS
            dfs(grid, m, n, i + d[0], j + d[1]);
        }
        return;

    }
}
// @lc code=end

