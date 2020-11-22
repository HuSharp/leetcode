/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-21 19:56:27
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-22 21:38:20
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
    private boolean res = true;

    public boolean isBalanced_1(TreeNode root) {
        if(root == null) {
            return true;
        }

        maxDepth(root);
        return res;
    }

    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if(Math.abs(leftDepth - rightDepth) > 1) {
            res = false;
            return 0;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /************************************** */
    // 首先进行 树形 DP 分析
    //  1、情况分析
    //     可能有 1、左边不平衡 2、右边不平衡   3、左右相差超过 1  
    //      4、平衡
    //  2、左右子树都需要知道 是否平衡，以及自己高度
    //  3、进行汇总
    public class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int h){
            this.isBalanced = isBalanced;
            this.height = h;
        }
    }

    // 4、设计递归函数
    private ReturnType process(TreeNode root) {
        if(root == null) {
            return new ReturnType(true, 0);
        }

        ReturnType leftData = process(root.left);
        ReturnType rightData = process(root.right);

        if(leftData.isBalanced && rightData.isBalanced 
            && Math.abs(leftData.height - rightData.height) <= 1) {
            return new ReturnType(true, Math.max(leftData.height, rightData.height) + 1);        
        }
        return new ReturnType(false, 0);// 高度无所谓了
    }

    public boolean isBalanced(TreeNode root) {
        ReturnType rootReturn = process(root);
        return rootReturn.isBalanced;
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