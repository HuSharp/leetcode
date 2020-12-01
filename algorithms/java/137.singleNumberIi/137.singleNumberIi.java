/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-30 18:44:23
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-30 19:05:25
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    // 1、求和法
    // 注意超界
    public int singleNumber_1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // 对 数组 和 set 分别就和，两倍的差值为所求值
        long numSum = 0;
        long setSum = 0;
        for(int i:nums) {
            if(!set.contains(i)) {
                set.add(i);
                setSum += i;
            }
            numSum += i;
        }

        return (int)((setSum * 3 - numSum) / 2);
    }

    // 法二
    // 位运算法
    // 将所有数的位数都加起来， 对 3 求余， 单独的那个数，其位数加上其他所有取余后，必然不为 3 的倍数
    public int singleNumber(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        // 共 32位
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int curBitVal = 0;
            for (int j = 0; j < nums.length; j++) {
                // if((nums[j] & (1 << i)) >= 1) {// 值得注意 此处不能这样
                // [-2,-2,1,1,-3,1,-3,-3,-4,-2]  就是上面行错的原因， 可以为 负数！！
                if(((nums[j] >> i) & 1) == 1){
                    curBitVal += 1;// 得到该数的位    
                }
                
            }
            if(curBitVal % 3 != 0){// 对 3 取余
                res |= (1 << i);    
            }
        }// 至此 得到 32 位的最终结果
        return res;
    }
}
// @lc code=end

