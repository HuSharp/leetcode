/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-13 23:40:59
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-13 23:54:44
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    TreeNode pre = null;// 采用一个全局变量指示当前的 pre
    public boolean isValidBST(TreeNode root) {
        // 中序遍历判断
        if(root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        // 遍历完之后，得到 pre
        if(pre != null && pre.val > root.val) {
            return false;
        }
        // 现在开始遍历右子树
        // 记得更新 pre 
        pre = root;
        boolean right = isValidBST(root.right);
        
        return left && right;
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