/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-16 10:58:26
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-16 11:38:12
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    // 暴力法
    public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];

        int pos1 = 0;
        int pos2 = 0;

        int mergePos = 0;
        while(pos1 < nums1.length && pos2 < nums2.length) {
            merge[mergePos++] = nums1[pos1] < nums2[pos2] ? nums1[pos1++] : nums2[pos2++]; 
        }
        while(pos1 < nums1.length) {
            merge[mergePos++] = nums1[pos1++];
        }
        while(pos2 < nums2.length) {
            merge[mergePos++] = nums2[pos2++];
        }

        System.out.println(mergePos/2 + " " +merge.length);
        if(mergePos % 2 == 0) {//为偶数
            return (merge[mergePos/2] + merge[mergePos/2-1]) / 2.00000;
        } else {
            return merge[mergePos/2];
        }
    }

    // 法二
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
    }
}
// @lc code=end

