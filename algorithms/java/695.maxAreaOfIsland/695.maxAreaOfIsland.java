/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-01-30 23:02:47
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-01-30 23:28:12
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {

    private int[][] direction = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length ==0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, m, n));
                }
            }
        }
        return maxArea;
    }

    // 进行 dfs 遍历
    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        // 0 表示为海洋， 1 表示为陆地， 2 表示已经遍历
        if (grid[i][j] != 1) {
            return 0;
        }


        // 标识此时点为已经遍历，防止发生死循环遍历情况
        grid[i][j] = 2;

        int num = 1;
        for (int[] d : direction) {
            num += dfs(grid, i + d[0], j + d[1], m, n);
        }
        // return 1 +
        // dfs(grid, i-1, j, m, n) +
        // dfs(grid, i+1, j, m, n) +
        // dfs(grid, i, j-1, m, n) +
        // dfs(grid, i, j+1, m, n);
        return num;
    }
}
// @lc code=end

