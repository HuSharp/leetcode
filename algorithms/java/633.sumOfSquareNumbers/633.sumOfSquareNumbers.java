/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-07 21:57:13
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-07 21:57:26
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=633 lang=java
 *
 * [633] Sum of Square Numbers
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        int end = (int)Math.sqrt(c);
        if(c  == end * end) {
            return true;
        }
        int left = 0;
        while(left <= end) {
            int sum = end*end + left*left;
            if( sum == c) {
                return true;
            } else if(sum < c) {
                left++;
            } else {
                end--;
            }
        } 
        return false;

    }
}
// @lc code=end

