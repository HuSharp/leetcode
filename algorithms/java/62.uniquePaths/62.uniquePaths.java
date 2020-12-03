/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-03 19:35:33
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-03 19:39:27
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    // 就是个杨辉三角
    public int uniquePaths(int m, int n) {
        if(m== 0 && n==0) {
            return 0;
        }

        // dp 来自 dp[i-1][j] 与 dp[i][j-1] + 当前值，取max
        int[][] dp = new int[m][n];
        // init
        // 第一列 和 第一行都为 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
// @lc code=end

