/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-17 23:27:05
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-17 23:45:18
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    // 双指针
    public boolean isPalindrome_1(int x) {
        if(x < 0) {
            return false;
        }
        String val = String.valueOf(x);
        
        int pos = 0;
        int reverPos = val.length()-1;
        while(pos != val.length()) {
            if(val.charAt(pos) != val.charAt(reverPos)) {
                return false;
            }
            pos++;
            reverPos--;
        }
        return true; 
    }

    // 直接计算
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int res = 0;
        int preVal = x;
        while(preVal != 0) {
            res = res * 10 + preVal % 10; 
            preVal /= 10;
        }

        return res == x;
    }
}
// @lc code=end

