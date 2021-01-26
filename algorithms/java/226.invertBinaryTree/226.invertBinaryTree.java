/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-19 12:48:14
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-01-26 20:26:28
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
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
    // 先序
    public TreeNode invertTree_1(TreeNode root) {
        // 我们发现只要把二叉树上的每一个节点的左右子节点进行交换，
        // 最后的结果就是完全翻转之后的二叉树。
        if(root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }

    // 后序
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
    /* 为什么中序不行？
    // 若
        invertTree(root.left);
        此处交换
        invertTree(root.right);
        
        那么会不断进入左子树，直至到 null
        返回时将左子树的 left 与 right 交换， 
        至此，左子树能被完全交换
        但是交换完之后进入右子树（此时的右子树是之前的左子树）， 开始交接
        因此到最后 根本没翻转

        二叉树题目的一个难点就是，如何把题目的要求细化成每个节点需要做的事情。
    */
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
