/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-17 23:51:44
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-17 23:55:10
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 1) {
            return strs;
        }

        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            str = longestCommonPrefix(strs[i], str);
        }

        return str;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int pos = 0;
        while(pos != str1.length() && pos != str2.length()) {
            if(str1.charAt(pos) != str2.charAt(pos)) {
                return str1.substring(0, pos+1);
            }
            pos++;
        }

        return str1;
    }
}
// @lc code=end

