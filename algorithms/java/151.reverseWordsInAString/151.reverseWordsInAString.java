/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-06 23:52:28
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-07 00:01:28
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        s = s.trim();// trim() 函数移除字符串两侧的空白字符

        // 首先去掉右侧空格
        int end = s.length()-1;
        int left = end;

        StringBuilder str = new StringBuilder();
        while(left >= 0) {
            // 遍历此处单词
            while(left>=0 && s.charAt(left) != ' ')   left--;
            str.append(s.substring(left+1, end+1));
            str.append(" ");
            // 跳过此处空格
            while(left>=0 && s.charAt(left) == ' ')   left--;
            end = left;
        }
        return str.toString().trim();
    }

}
// @lc code=end

