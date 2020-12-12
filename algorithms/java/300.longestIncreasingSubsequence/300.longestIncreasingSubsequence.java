/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-03 12:42:04
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-12 23:19:50
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    // 最长上升子序列
    public int lengthOfLIS_1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }        

        // f[i] 表示以 a[i] 结尾的最长子序列长度
        // f[i] = {1, f[j]+1} && a[j] < a[i], j < i
        int[] f = new int[nums.length];
        f[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(1, f[i]);
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        // 值得注意的是， 最后结果不一定为 f[nums.length]
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, f[i]);
        }

        return res;
    }

    // 明显dp
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len+1];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        
        // 值得注意的是， 最后结果不一定为 f[nums.length]
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
// @lc code=end

