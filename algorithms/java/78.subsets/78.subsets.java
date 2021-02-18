import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-02-18 22:37:32
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-02-18 23:01:52
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    // 可以理解为每次都从 1 开始，找长度为 n 的组合
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }
        
        List<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        // 每个子集大小
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, 0, i, path, res);
        }

        return res;
    }

    // k 表示当前为 几个
    private void dfs(int[] nums, int start, int size, List<Integer> path, List<List<Integer>> res) {
        if (size == path.size()) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            path.add(nums[i]);
            dfs(nums, i + 1, size, path, res);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

