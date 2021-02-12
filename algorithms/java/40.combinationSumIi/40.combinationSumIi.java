import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-02-12 22:24:43
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-02-12 23:17:13
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);

        List<Integer> path = new LinkedList<>();
        dfs(candidates, target, 0, res, path);

        return res;

    }

    private void dfs(int[] candidates, int target, int begin, List<List<Integer>> res, List<Integer> path) {
        if (target == 0) {
            res.add(new LinkedList<>(path));
            return;
        }

        // i 表示的正是同一层的分支所要减去的数
        for (int i = begin; i < candidates.length; i++) {
            // 若升序排序后， 之后的都已经小于 0 了，那么就没必要再继续了
            if (target - candidates[i] < 0) {
                return;
            }

            // 同一层节点，如果上一个分支和当前分支删除的数相同，那么只保留上一个分支即可
            if (i > begin && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, res, path);

            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

