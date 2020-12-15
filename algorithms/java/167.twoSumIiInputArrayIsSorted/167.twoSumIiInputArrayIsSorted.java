/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-15 23:42:38
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-15 23:45:17
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left != right) {
            int sum = numbers[left] + numbers[right];
            if(sum < target) {
                left++;
            } else if(sum > target) {
                right--;
            } else {
                return new int[]{left+1, right+1};
            }
        }

        return null;
    }
}

// @lc code=end

