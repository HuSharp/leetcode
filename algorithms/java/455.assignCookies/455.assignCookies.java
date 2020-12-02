import java.util.Arrays;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-02 23:05:41
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-02 23:09:37
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 首先将两个数组都按照升序排列
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        int cnt = 0;
        while(j < s.length && i < g.length) {
            if(g[i] <= s[j]) {
                cnt++;
                i++;
            }
            j++;
        }
        return cnt;
    }
}
// @lc code=end

