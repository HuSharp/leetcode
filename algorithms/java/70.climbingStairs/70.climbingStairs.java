/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-19 10:59:14
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-19 11:04:25
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if(n == 0) {
            return 0;
        }
        // dp[x] 表示 到 x 阶的方法数 
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
// @lc code=end

