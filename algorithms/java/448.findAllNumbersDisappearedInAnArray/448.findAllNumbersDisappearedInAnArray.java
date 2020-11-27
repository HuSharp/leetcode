import java.util.LinkedList;
import java.util.List;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-27 11:05:28
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-27 12:56:02
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 */

// @lc code=start
class Solution {
    // 建立 n 个桶。 进行标记
    public List<Integer> findDisappearedNumbers_1(int[] nums) {
        boolean[] backet = new boolean[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            if(backet[nums[i]] == false) {
                backet[nums[i]] = true;
            }
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 1; i < backet.length; i++) {
            if(backet[i] == false) {
                res.add(i);
            }
        }

        return res;
    }

    // 法二
    // 对于这种数组元素在 [0, n-1] 范围内的问题，
    // 可以将值为 i 的元素调整到第 i 个位置上进行求解。
    // 在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，
    // 就可以知道 i 值重复， 将其 乘以 -1
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for ( int pos = 0; pos < nums.length; pos++) {
            int num = Math.abs(nums[pos]);// 取当前索引值
            if(nums[num-1] > 0) {//说明是第一次出现该值
                nums[num-1] *= -1;
            }
        }// 至此，已经将所有出现过的值都标记为负数
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;

    }
}
// @lc code=end

