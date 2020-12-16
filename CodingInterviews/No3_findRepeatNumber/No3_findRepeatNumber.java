/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-09 18:40:48
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-09 19:08:17
 * @@Email: 8211180515@csu.edu.cn
 */

package CodingInterviews;

import java.util.HashSet;

/*
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字重复了，
也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
*/
public class No3_findRepeatNumber {
    // 法一 两次遍历
    public int findRepeatNumber_1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            } else{
                return nums[i];
            }
        }
        return 0;
    }

    // 法二
    // 由于是不重复的数字， 因此可以采用将索引值与当前值*-1来建立映射
    // 采用两次遍历
    public int findRepeatNumber_2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int curNum = Math.abs(nums[i]);
            if(nums[curNum] > 0) {
                //说明之前没有映射过
                nums[curNum] *= -1; 
            } 
        }
        // 第二次， 对不为负数的返回即可
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                return nums[i];
            }
        }
        return  0;
    }

    // 法三
    // 一直交换数组当前值与索引位置值，直到索引与当前值相等时，再向后移
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            
            while(nums[i] != i) {
                if(nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
                // nums[nums[i]] *= -1;
            }
        }
        return -1;
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}

