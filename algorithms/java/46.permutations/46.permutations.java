import java.util.LinkedList;
import java.util.List;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-15 23:52:25
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-02-06 21:50:35
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }

        int len = nums.length;
        boolean[] used = new boolean[len];
        List<Integer> path = new LinkedList<Integer>();
        backTrace(nums, 0, len, used, path, lists);
        
        return lists;
    }

    private void backTrace(int[] nums, int cur, int len, boolean[] used,
                            List<Integer> path, List<List<Integer>> lists) {
        // 当遍历完所有长度后， 进行返回
        if (cur == len) {
            lists.add(new LinkedList<>(path));
            return;
        }

        // 对没有 used 的数字进行选择
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                // 首先将其变为已经使用
                used[i] = true;
                path.add(nums[i]);
                backTrace(nums, cur + 1, len, used, path, lists);
                // 进行回溯
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
// @lc code=end

