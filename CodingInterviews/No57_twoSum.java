/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-15 23:56:08
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-15 23:56:24
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

import java.util.HashMap;

public class No57_twoSum {
        // 递增数组
        public int[] twoSum_1(int[] nums, int target) {

            int[] res = new int[2];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                if(!map.containsKey(nums[i])) {
                    map.put(nums[i], i);
                }
                // 判断是否有和
                if(map.containsKey(target - nums[i])) {
                    if(map.get(nums[i]) == map.get(target - nums[i]) ) {
                        continue;
                    }
                    res[0] = nums[i];
                    res[1] = target - nums[i];
                    return res;
                }
            }   
            return res;
        }
    
        // 二分法
        public int[] twoSum(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
    
            for(int i = 0; i < nums.length; i++ ) {
                left = i + 1;// 下一个找
                while(left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if(nums[mid] < target - nums[i]) {
                        left = mid + 1;
                    } else if(nums[mid] > target - nums[i]){
                        right = mid - 1;
                    } else {
                        return new int[]{nums[i], nums[mid]};
                    }
                }
            }
            return null;
        }
}
