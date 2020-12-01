import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-30 18:20:03
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-30 18:42:26
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    // 1、 异或位运算
    public int singleNumber_1(int[] nums) {

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    // 2、栈 将相等的压入
    public int singleNumber_2(int[] nums) {
        // 首先对 nums 进行排序，再压栈操作
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();

        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(stack.isEmpty()) {
                stack.push(nums[i]);
            } else {
                if(stack.peek() != nums[i]) {
                    return stack.pop();
                } else {// 说明相等
                    stack.pop();
                }
            }
        }
        return nums[nums.length-1];
    }

    // 3、指针每次走两步
    public int singleNumber_3(int[] nums) {
        Arrays.sort(nums);
        int pos = 0;
        while(pos < nums.length-1 && pos < nums.length) {
            if(nums[pos] != nums[pos+1]) {
                return nums[pos];
            } else {
                pos+=2;
            }
        }
        return nums[pos];
    }

    // 4、求和法
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // 对 数组 和 set 分别就和，两倍的差值为所求值
        int numSum = 0;
        int setSum = 0;
        for(int i:nums) {
            if(!set.contains(i)) {
                set.add(i);
                setSum += i;
            }
            numSum += i;
        }

        return (setSum * 2 - numSum);
    }
    // HashMap 和 set 的两次遍历就不说了

}
// @lc code=end

