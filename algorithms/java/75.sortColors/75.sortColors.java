/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-29 22:08:04
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-27 14:54:59
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        partition(nums, 0, nums.length-1);
        
    }

    // pivot 为 1
    private void partition(int[] nums, int l, int r) {
        int left = l-1;
        int right = r+1;

        int pos = l;
        while(pos != right) {
            if(nums[pos] < 1) {
                swap(nums, ++left, pos++);
            } else if(nums[pos] > 1) {
                swap(nums, --right, pos);
            } else {
                pos++;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

