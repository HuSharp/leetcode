/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-29 22:08:04
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-29 22:12:30
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
        partition(nums, 0, nums.length);
        
    }

    // pivot 为 1
    private void partition(int[] nums, int l, int r) {
        int less = l-1;
        int more = r;
        int pos = l;// 当前位置
        while(pos < more) {
            if(nums[pos] < 1) {// 为 0 放在左侧
                swap(nums, ++less, pos++);
            } else if(nums[pos] > 1) {
                swap(nums, pos, --more);
            } else {
                pos++;// 相等则指向下一个
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

