import java.util.HashMap;
import java.util.Map;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-13 12:06:51
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-13 12:16:58
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    // 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，
    // value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        // 不重复子串的开始位置为 start，结束位置为 end
        for (int end = 0, start = 0; end < n; end++) {
            char ch = s.charAt(end);
            if(map.containsKey(ch)) {
                // 遇到与 [start, end] 区间内字符相同的情况，
                // 此时将字符作为 key 值，获取其 value 值，
                // 并更新 start，此时 [start, end] 区间内不存在重复字符

                start = Math.max(start, map.get(ch));
            }
            // 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
            res = Math.max(res, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return res;
    }
}
// @lc code=end

