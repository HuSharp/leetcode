/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-26 17:26:19
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-26 17:26:28
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> res  = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        back(root, sum, new ArrayList<>());

        return res;
    }

    // 使用回溯法解决
    private void back(TreeNode root, int sum, ArrayList<Integer> array) {
        if(root == null) {
            return;
        }

        array.add(root.val);
        sum -= root.val;
        // 若为叶子节点， 且满足sum
        if(root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(array));
        } else {
            // 否则 进入到左右子树
            back(root.left, sum, array);
            back(root.right, sum, array);
        }

        // 至此判断完当前值是否满足
        array.remove(array.size() - 1);
    }
}
// @lc code=end

