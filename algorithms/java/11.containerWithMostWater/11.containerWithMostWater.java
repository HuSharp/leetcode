/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-15 23:14:10
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-15 23:33:36
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    // 法一 暴力法
    public int maxArea_1(int[] height) {
        int resMax = 0;
        for(int i = 0; i < height.length; i++ ) {
            // 遍历右侧所有竖轴， 用当前最短的轴来做矩阵积
            int curLow = 0;
            for(int j = i; j < height.length; j++) {

                curLow = height[j] < height[i] ? height[j] : height[i];
                int curMatrix = curLow * (j - i);
                resMax = Math.max(resMax, curMatrix);
            }
            // System.out.print(resMax + " ");
        }

        return resMax;
    }

    // 法二 双指针法
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int res = 0;
        while(left != right) {
            int curMin = Math.min(height[left], height[right]);
            res = Math.max(res, (right - left) * curMin);
            if(height[left] < height[right]) {
                left++;
            } else {
                right++;
            }
        }

        return res;
    }
}

// @lc code=end

