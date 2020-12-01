import java.util.HashSet;
import java.util.Set;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-30 19:07:23
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-30 20:01:26
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */

// @lc code=start
class Solution {
    // 法一 HashSet
    public int[] singleNumber_1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);// 将出现两次的移除
            }
        } // 至此 set 中只有出现一次的

        int[] res = new int[2];
        int i = 0;
        for (Integer integer : set) {
            res[i++] = integer;
        }
        return res;
    }

    // 法二 异或
    public int[] singleNumber(int[] nums) {
        int diff = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff ^= nums[i];
        } // 此时得到的是该两数的异或结果
          // 该两数必然是有不同的位不同，即 diff 至少 1 位不同。
          // 依照其中某位进行分类， 然后按照之前 137 题模式来写
          // 可以通过 x & (-x) 来保留最右位
        diff &= (-diff);
        int[] res = new int[2];
        for (int i : nums) {
            if ((i & diff) == 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}
// @lc code=end
