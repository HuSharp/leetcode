/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-27 12:44:59
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-30 23:03:47
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    // 题目：假设只有一个重复的整数，找出这个重复的数。
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length-1;

        // 二分查找，当[left, right]统计数量大于区间长度时， 那说明重复数据在其中
        while(left < right) {
            int mid = ((right - left) >> 1) + left;

            int cnt = 0;// 统计区间内数量
            for (int i : nums) {
                if(i <= mid) {
                    cnt++;
                }
            }
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if(cnt > mid) {//说明在左侧
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid + 1, right]
                left = mid+1;
            }
        }

        return left;
    }

    
}
// @lc code=end

