/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-27 10:42:38
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-27 10:50:09
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    // 采用 快慢指针， 慢指针标记 0 区域， 快指针遇到 0 便跳过， 遇到非 0 就交换
    public void moveZeroes(int[] nums) {
        if(nums == null) {
            return; 
        }
        int len = nums.length;
        int slow = 0;
        int fast = 0;
        while(fast < len && nums[fast] == 0) {
            fast++;
        }// 至此 fast 到达最开始的非 0 处
        while(fast != len) {
            swap(nums, slow++, fast++);
            while(fast != len && nums[fast] == 0){
                fast++;
            }
        }// 至此 完成
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
// @lc code=end

