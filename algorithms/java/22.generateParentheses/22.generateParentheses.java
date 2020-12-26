import java.util.LinkedList;
import java.util.List;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-26 18:38:07
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-26 22:42:35
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    // 采用回溯
    public List<String> generateParenthesis_back(int n) {
        if(n == 0) {
            return new LinkedList<>();
        }
        List<String> res = new LinkedList<>();
        dfs(left, right, res);

        return res;
    }

    private void dfs(int left, int right, List<String> path, String str) {
        if(right == 0 && left == 0) {
            path.add(str);
            return;
        }
        if(left > 0) {
            dfs(left-1, right, path, str+"(");
        }
        if(right > left) {
            dfs(left, right-1, path, str+")");
        }
    }

    // dp
    public List<String> generateParenthesis(int n) {
        if(n == 0) {
            return new LinkedList<>();
        }
        List<String> res = new LinkedList<>();
        // 剩下的括号要么在这一组新增的括号内部，要么在这一组新增括号的外部（右侧）。
        // 即递推公式是 dp[i]="("+dp[m]+")"+dp[k]
        // 其中  m+k=i-1
        List<String>[] dp = new LinkedList[n + 1];
        // init
        List<String> dp0 = new LinkedList<>();
        dp0.add("");
        dp[0] = dp0;
        for (int i = 1; i <= n; i++) {

            List<String> cur = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                int k = i - 1 - j;
                List<String> str1 = dp[j];
                List<String> str2 = dp[k];
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }

            dp[i] = cur;
        }

        return dp[n];
    }
}
// @lc code=end

