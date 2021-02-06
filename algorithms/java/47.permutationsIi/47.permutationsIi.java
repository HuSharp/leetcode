/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-15 23:54:38
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-02-06 22:19:55
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
        List<List<Integer>> lists = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }

        Arrays.sort(nums);// 进行排序为递增，好判断重复值
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
                // 进行剪枝
                // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                // 如果前一个重复元素没有使用过，那么在当前重复元素下一层的可选项中一定会存在，那么一定会重复
                if (i > 0 && nums[i-1] == nums[i] && !used[i-1] ) {
                    continue;
                }

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

