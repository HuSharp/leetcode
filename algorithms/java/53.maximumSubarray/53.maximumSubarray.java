/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-03 20:11:39
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-03 20:20:11
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    // 依次遍历， 若累加和小于 0， 那么必然不会为最终结果的左边，
    // 因此此时将 sum 取为 当前值  
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int res = Integer.MIN_VALUE;// 最终返回值
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return res;
    }
}
// @lc code=end

