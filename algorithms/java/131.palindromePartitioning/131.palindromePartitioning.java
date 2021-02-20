import java.util.LinkedList;
import java.util.List;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-02-20 21:01:36
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-02-20 21:20:30
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();

        if (s == null || s.length() == 0) {
            return res;
        }

        List<String> path = new LinkedList<>();
        dfs(s, res, path);

        return res;
    }

    private void dfs(String s, List<List<String>> res, List<String> path) {
        if (s.length() == 0) {
            res.add(new LinkedList(path));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                path.add(s.substring(0, i+1));
                dfs(s.substring(i+1), res, path);
                path.remove(path.size() - 1);
            }
        }
    }

    // 加上一个判断是否是回文串的函数
    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

