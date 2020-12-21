import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-21 17:48:10
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-21 22:40:36
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    // 套用两数之和的想法
    public List<List<Integer>> threeSum_1  (int[] nums) {
        Set<List<Integer>> lists = new HashSet<>(); 

        // 首先进行数组的排序
        Arrays.sort(nums);
        // 对每一个元素进行 负数的判断
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {// 说明重复， 跳过
                continue;
            }
            int sum = -1 * nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            
            // 类似两数之和
            for (int j = i+1; j < nums.length; j++) {

                List<Integer> list = new LinkedList<>();
                if(!map.containsKey(nums[j])) {
                    map.put(nums[j], j);
                }
                
                if(map.containsKey(sum - nums[j])) {
                    if(map.get(sum - nums[j]) != j) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(sum - nums[j]);

                        lists.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(lists);
    }

    // 法二 双指针
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();

        // 首先进行数组的排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                return lists;
            }
            if(i > 0 && nums[i] == nums[i-1]) {// 说明重复， 跳过
                continue;
            }

            int sum = -1 * nums[i];
            int left = i;
            int right = nums.length-1;
            
            
            while(left < right) {
                if(nums[left] + nums[right] == sum) {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[i]);

                    lists.add(list);

                    while(left < right && nums[left] == nums[left++]) {
                        left++;
                    } 
                    while(left < right && nums[right] == nums[right--]) {
                        right--;
                    } 
                } else if(nums[left] + nums[right] > sum){
                    right--;
                } else {
                    left++;
                }
            }

        }
        return lists;
    }

}
// @lc code=end

