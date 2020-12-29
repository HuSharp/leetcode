/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-29 12:13:36
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-29 12:39:01
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    // 采用双指针
    public int mySqrt(int x) {
        long  l = 0;
        long  r = x / 2 + 1;
        long  mid = 0;
        while(l <= r) {
            mid = ((r - l) >> 1) + l;
            long  mult = mid * mid;
            if( mult == x) {
                return (int)mid;
            } else if(mult > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) (mid * mid > x ? mid - 1 : mid) ;
    }
}
// @lc code=end

