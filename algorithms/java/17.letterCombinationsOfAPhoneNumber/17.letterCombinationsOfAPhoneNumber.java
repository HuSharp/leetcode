import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-25 10:25:44
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-25 12:02:15
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if(digits == null || digits.length() == 0) {
            return res;
        }
        // 即为全排列
        char[] sc = digits.toCharArray();
        int len = digits.length();

        mergeToStr(sc, len, 0, res, "");
        return res;
    }

    // 采用 dfs 来进行全排列
    private void mergeToStr(char[] nums, int len, int depth, List<String> res, String curStr) {
        if(len == depth) {
            res.add(curStr);
            return;
        }

        String str = map.get(nums[depth] - '0');
        int curLen = str.length();
        for (int i = 0; i < curLen; i++) {
            mergeToStr(nums, len, depth+1, res, curStr+str.charAt(i));
        }
        return;
    }


    final Map<Integer, String> map = new HashMap<>() {
        {
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }
    };
}
// @lc code=end

