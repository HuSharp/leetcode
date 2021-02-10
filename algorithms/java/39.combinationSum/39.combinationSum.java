import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-02-10 21:53:44
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-02-10 22:17:55
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        List<Integer> path = new LinkedList<>();
        dfs(res, path, candidates, target, 0);
        
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int begin) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new LinkedList<>(path));
            }
            return;
        }
        // // 原始版本
        // for (int i = begin; i < candidates.length; i++) {
        //     path.add(candidates[i]);
        //     dfs(res, path, candidates, target - candidates[i], i);// begin 仍然是 i，因为每一个元素可以重复使用
        //     path.remove(path.size() - 1);
        // }

        // 现进行剪枝
        /*
        根据上面画树形图的经验，如果 target 减去一个数得到负数，那么减去一个更大的树依然是负数，
        同样搜索不到结果。基于这个想法，我们可以对输入数组进行排序，添加相关逻辑达到进一步剪枝的目的；
        排序是为了提高搜索速度，对于解决这个问题来说非必要。
        但是搜索问题一般复杂度较高，能剪枝就尽量剪枝。实际工作中如果遇到两种方案拿捏不准的情况，都试一下。*/
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                return;
            }

            path.add(candidates[i]);
            dfs(res, path, candidates, target - candidates[i], i);// begin 仍然是 i，因为每一个元素可以重复使用
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

