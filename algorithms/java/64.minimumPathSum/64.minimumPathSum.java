/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-03 19:17:24
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-03 19:25:10
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        // dp 来自 dp[i-1][j] 与 dp[i][j-1] + 当前值，取max
        int[][] dp = new int[m][n];

        // init
        // 第一列
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        // max 必定为最后一个
        return dp[m-1][n-1];
    }
}
// @lc code=end

