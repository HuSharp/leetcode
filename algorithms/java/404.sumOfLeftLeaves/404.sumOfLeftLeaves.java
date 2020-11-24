/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-24 23:25:21
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-24 23:35:17
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
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
    // int res = 0;// 记录和
    // public int sumOfLeftLeaves(TreeNode root) {
    //     if(root == null) {
    //         return res;
    //     }
    //     LeftLeaves(root, root.left);
    //     LeftLeaves(root, root.right);

    //     return res;
    // }
    // // 采用两个参数标注 左孩子
    // private void LeftLeaves(TreeNode parent, TreeNode child) {
    //     // 首先判断是否为 叶子节点
    //     if(child == null) {
    //         return;
    //     }
    //     // 为叶子节点
    //     if(child.left == null && child.right == null) {
    //         if(parent.left == child) {//为左子节点
    //             res += child.val;
    //         }
    //         return;
    //     }
    //     LeftLeaves(child, child.left);
    //     LeftLeaves(child, child.right);

    //     return;
    // }
    // 进行直接返回
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 只需对该点的左节点进行判断， 判断是否为 叶子节点
        if(isLeaf(root.left)) {// 若是， 那么直接返回即可， 因为左边已经到左子树了
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    // 判断是否为叶子节点
    private boolean isLeaf(TreeNode node) {
        if(node == null) {
            return false;// 为空必然不为叶子节点
        }
        return node.left == null && node.right == null;
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