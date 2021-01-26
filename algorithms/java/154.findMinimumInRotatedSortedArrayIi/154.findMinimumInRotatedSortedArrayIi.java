/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-01-26 20:16:59
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-01-26 20:17:12
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    // 采用二分进行判断
    public int findMin(int[] nums) {
        // 左右指针分别指向两端
        int l = 0;
        int r = nums.length - 1;

        // 进行二分查找
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            if (nums[mid] < nums[r]) {
                // 说明位于左排序区间 5 6 1 2 3 4
                r = mid;
            } else if (nums[mid] > nums[r]) {
                // 说明位于右排序区间 3 4 5 6 1 2
                l = mid + 1;
            } else if (nums[mid] == nums[r]) {
                // 此时按序遍历
                for (int i = l; i < r - 1; i++) {
                    if (nums[i] > nums[i + 1]) {
                        return nums[i + 1];
                    }
                }
                // 至此说明从 mid 到 r 都相等
                return nums[l];
            }
        }
        return nums[l];
    }
}
// @lc code=end

