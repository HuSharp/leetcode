import java.util.HashMap;
import java.util.Map;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-01-05 16:57:27
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-01-05 17:35:26
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {
    // 贪心思路
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int cnt = 0;
        String res = "";
        while(cnt < 13) {
            while(num >= nums[cnt]) {
                num -= nums[cnt];
                res += romans[cnt];
            }
            cnt++;
        }
        return res;

    }

    
    
}
// @lc code=end

