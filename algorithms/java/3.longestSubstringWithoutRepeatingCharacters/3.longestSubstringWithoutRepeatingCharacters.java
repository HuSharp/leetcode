import java.util.HashMap;
import java.util.Map;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-13 12:06:51
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-13 23:01:13
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {

    // 滑动窗口法
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int res = 0;
        while(end != n) {
            char ch = s.charAt(end);
            if(map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) + 1);// 表示从该字符所在位置下一个才不重复
            }
            // 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
            map.put(ch, end);
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
// @lc code=end

