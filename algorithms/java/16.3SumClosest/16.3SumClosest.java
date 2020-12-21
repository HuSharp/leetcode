import java.util.Arrays;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-21 22:52:21
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-21 23:04:51
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        // 需要给result一个初始值，这个值还不能越界，所以取0,1,2是最方便的
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {

            int left = i+1;
            int right = nums.length-1;
            
            while(left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;

                if(sum == target) {
                    return target;
                    
                } else if(sum > target){
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
    }
}
// @lc code=end

