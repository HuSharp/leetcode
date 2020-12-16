/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-16 12:05:40
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-16 14:25:12
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    // DP
    public String longestPalindrome(String s) {
        char[] sc = s.toCharArray();
        int n = s.length();

        // dp 数组
        boolean[][] dp = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < n-1; i++) {
            if(sc[i] == sc[i+1]) {
                dp[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // 从长度为 3 开始
        for (int len = 3; len <= n; len++) {
            for (int pos = 0; pos <= n - len; pos++) {
                int end = pos + len - 1;
                if(sc[pos] == sc[end] && dp[pos+1][end-1]) {
                    dp[pos][end] = true;
                    maxLen = len;
                    start = pos;
                }
            }
        }
        
        return s.substring(start, start + maxLen);
    }
}
// @lc code=end

