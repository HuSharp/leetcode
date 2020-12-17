/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-17 16:41:34
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-17 23:23:14
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }

        int len = s.length();
        int pos = 0;
        while(pos++ < len) {
            int numMod = pos % numRows;
            int curMod = Math.min(numMod, numRows - pos);
            arr[curMod].append(s.charAt(pos));
        }

        return String.join("", arr);
        
    }
}
// @lc code=end

