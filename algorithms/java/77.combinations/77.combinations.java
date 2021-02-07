import java.util.LinkedList;
import java.util.List;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-02-07 22:27:13
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-02-07 22:50:26
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();

        if (n == 0 || k <= 0 || k > n) {
            return res;
        } 

        List<Integer> path = new LinkedList<>();
        backTrace(n, k, 1, path, res);

        return res;
    }

    private void backTrace(int n, int k, int begin, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }

        // 搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
        // 接下来要选择的元素个数 = k - path.size()
        // ----> 搜索起点的上界 = n - (k - path.size()) + 1
        for (int i = begin; i <= (n - (k - path.size()) + 1); i++) {
            path.add(i);
            backTrace(n, k, i + 1, path, res);

            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

