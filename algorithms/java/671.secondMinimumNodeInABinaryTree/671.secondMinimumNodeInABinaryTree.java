import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-25 00:00:25
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-27 14:03:50
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=671 lang=java
 *
 * [671] Second Minimum Node In a Binary Tree
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
    // 1、 暴力
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    Set<Integer> set = new HashSet<>();
    public int findSecondMinimumValue_1(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        // 叶子节点返回 -1
        if(root.left == null && root.right == null) {
            return -1;
        }
        traverse(root);
        if(heap.size() == 1) {
            return -1;
        }
        // 至此 表示存在
        heap.poll();
        return heap.poll();
        
    }

    private void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        if(!set.contains(root.val)) {
            set.add(root.val);
            heap.add(root.val);    
        }
        
        traverse(root.left);
        traverse(root.right);
    }

    // 2、 递归写法
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) {
            return -1;
        }
        // 叶子节点返回 -1
        if(root.left == null && root.right == null) {
            return -1;
        }

        // 
        int left = root.left.val;
        int right = root.right.val;
        // 进入相等数递归
        if(left == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if(right == root.val) {
            right = findSecondMinimumValue(root.right);
        }
        // 至此 表示是不相等的数中找 min
        if(left != -1 && right != -1) {
            return Math.min(left, right);
        }
        // 至此表示至少一个为 -1
        if(left != -1) {
            return left;
        } 
        return right;
        
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