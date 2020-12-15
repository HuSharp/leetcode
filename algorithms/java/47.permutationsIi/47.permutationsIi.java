/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-15 23:54:38
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-15 23:54:44
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        int len = nums.length;
        if(len == 0) {
            return res;
        }

        Arrays.sort(nums);// 排序成递增
        boolean[] used = new boolean[len];
        LinkedList<Integer> path = new LinkedList<>();
        dfs(nums, res, used, 0, len, path);

        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, boolean[] used,
                    int depth, int len, LinkedList<Integer> path) {
        if(depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < len; i++) {
            if(used[i] == false ) {

                // 进行剪枝
                if(i > 0 && nums[i] == nums[i-1] && (used[i-1] == false)) {
                    continue;
                }

                path.add(nums[i]);
                used[i] = true;

                dfs(nums, res, used, depth + 1, len, path);
                // 回溯
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
// @lc code=end

