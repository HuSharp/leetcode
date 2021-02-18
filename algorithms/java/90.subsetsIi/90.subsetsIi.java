/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-02-18 23:03:43
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-02-18 23:18:58
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }
        
        List<Integer> path = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        // 每个子集大小
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, 0, i, path, res, visited);
        }

        return res;
    }

    // k 表示当前为 几个
    private void dfs(int[] nums, int start, int size, List<Integer> path, List<List<Integer>> res, boolean[] visited) {
        if (size == path.size()) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            if (i != 0 && nums[i] == nums[i-1] && visited[i-1] == false) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, i + 1, size, path, res, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
// @lc code=end

