import jdk.nashorn.api.tree.Tree;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-23 18:18:58
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-23 18:39:03
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
class Solution {

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // 对当前点进行判断
        // 1 一个 为空，则返回另一个
        // 2 两个都不为空， 则返回 min
        if(leftDepth == 0) {
            return rightDepth + 1;
        } else if(rightDepth == 0) {
            return leftDepth + 1;
        } else {
            return Math.min(leftDepth, rightDepth) + 1;
        } 
    }


}
// @lc code=end

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}