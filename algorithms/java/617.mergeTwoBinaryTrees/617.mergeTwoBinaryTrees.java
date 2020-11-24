/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-22 22:22:44
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-22 22:23:06
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=617 lang=java
 *
 * [617] Merge Two Binary Trees
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if(t1 == null && t2 == null) {
                return null;
            }
            // 至此表示最多一个为 null
            if(t1 == null) {
                return t2;
            }
            if(t2 == null) {
                return t1;
            }
            TreeNode root = new TreeNode(t1.val + t2.val);
            // 进行合并
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
    
            return root;
    }
}
// @lc code=end

