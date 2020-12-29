/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-28 19:44:48
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-29 23:21:34
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    // 二分查找
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r  = nums.length - 1;

        int[] res = new int[2];
        
        while(l <= r) {
            int mid = ((r - l) >> 1 ) + 1;
            if(nums[mid] == target) {
                // 从当前点顺序往后往前
                int pos = mid;
                for ( ; pos < nums.length - 1; pos++) {
                    if(nums[pos] != target){
                        res[0] = pos-1;
                        break;
                    }
                }
                pos = mid;
                for ( ; pos >= 0; pos--) {
                    if(nums[pos] != target){
                        res[1] = pos+1;
                        break;
                    }
                }
                return res;
            } else if(nums[mid] > target) {
                l = mid + 1;
            } else if(nums[mid] < target) {
                r = mid - 1;
            }
        }

        return res;
    }
}
// @lc code=end

