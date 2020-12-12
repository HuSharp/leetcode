/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-11 23:16:14
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-11 23:29:00
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */

// @lc code=start
class Solution {
    // DP
    public int integerBreak(int n) {
        int[] dp = new int[n+1];

        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i-j], j * (i-j)));
            }
        }

        return dp[n];
    }
}
// @lc code=end

