import java.util.Map;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-01-03 23:36:20
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-01-05 19:22:38
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {

        int len = s.length();

        int cnt = 0;
        int res = 0;
        while(cnt < len) {
            if(cnt + 1 < len && map.containsKey(s.substring(cnt, cnt+2))) {
                res += map.get( s.substring(cnt, cnt+2) );
                cnt += 2;
            } else {
                res += map.get( s.substring(cnt, cnt+1) );
                cnt++;
            }
        }
        return res;
    }

    Map<String, Integer> map = new HashMap<>() {
        {
            put("I", 1);
            put("IV", 4);
            put("V", 5);
            put("IX", 9);
            put("X", 10);
            put("XL", 40);
            put("L", 50);
            put("XC", 90);
            put("C", 100);
            put("CD", 400);
            put("D", 500);
            put("CM", 900);
            put("M", 1000);
        }
    };



}
// @lc code=end

