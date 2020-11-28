import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-28 13:55:03
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-28 14:18:39
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
    // 采用一个 Map
    public int firstUniqChar_1(String s) {
        if(s == null) {
            return -1;
        }
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
            } else {
                // 那么就置为 -1
                map.put(s.charAt(i), -1);
            }
        }

        for (int i = 0; i < len; i++) {
            if(map.get(s.charAt(i)) == 0) {
                return i;
            } 
        }
        return -1;
    }


    // 变式：若是返回字符， 而非下标
    // 在字符串 s 中找出第一个只出现一次的字符。
    //如果没有，返回一个单空格。 s 只包含小写字母。
    // 法二 采用 HashMap
    public char firstUniqChar(String s) {
        if(s == null) {
            return ' ';
        }
        HashMap<Character, Boolean> map = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> kEntry : map.entrySet()) {
            if(kEntry.getValue()) {// 说明存在
                return kEntry.getKey();
            }
        }
        return ' ';
    }
}
// @lc code=end

