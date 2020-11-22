/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-22 12:15:04
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-22 12:48:12
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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
    private int maxLevel = 0;

    public int diameterOfBinaryTree_1(TreeNode root) {
        if(root == null) {
            return 0;
        }

        maxTree(root);
        
        return maxLevel;
    }

    private int maxTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        // 第一种
        int leftMaxLen = maxTree(root.left);
        // 第二种
        int rightMaxLen = maxTree(root.right);

        // 第三种是 左右子树深度和
        int sumLen = levelTree_1(root.left) + levelTree(root.right);

        int rootMaxLen = Math.max(Math.max(leftMaxLen, rightMaxLen), sumLen);
        maxLevel = Math.max(maxLevel, rootMaxLen);

        return rootMaxLen;
    }

    private int levelTree_1(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftLevel = levelTree(root.left);
        int rightLevel = levelTree(root.right);

        return Math.max(leftLevel, rightLevel) + 1;
    }


    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        levelTree(root);
        
        return maxLevel;
    }

    // 就是算深度
    private int levelTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftLevel = levelTree(root.left);
        int rightLevel = levelTree(root.right);
        maxLevel = Math.max(leftLevel + rightLevel, maxLevel);


        return Math.max(leftLevel, rightLevel) + 1;
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