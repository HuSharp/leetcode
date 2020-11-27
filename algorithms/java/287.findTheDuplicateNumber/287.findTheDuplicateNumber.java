/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-27 12:44:59
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-27 12:55:45
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    // 类似 448 思路
    public int findDuplicate(int[] nums) {
        for (int pos = 0; pos < nums.length; pos++) {
            int num = Math.abs(nums[pos]);// 取当前索引值
            if(nums[num-1] > 0) {//说明是第一次出现该值
                nums[num-1] *= -1;
            } else {
                return num;
            }
        }
        return 0;
    }
}
// @lc code=end

