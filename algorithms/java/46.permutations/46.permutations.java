/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-15 23:52:25
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-15 23:53:00
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
        int len = nums.length;
        List<List<Integer>> res =  new LinkedList<>();
        if(len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new LinkedList<>();
        dfs(nums, len, 0, path, used, res);

        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, 
                    boolean[] used, List<List<Integer>> res) {
        if(depth == len) {
            res.add(new LinkedList<>(path));
            return;
        }

        // 在未选择数中依次选择一个元素作为下一个
        for(int i = 0; i < len; i++) {
            if( used[i] == false) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth+1, path, used, res);
                // 进行回溯
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
// @lc code=end

