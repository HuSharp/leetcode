import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-25 18:03:48
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-25 18:23:06
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
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
    // 层次遍历, 主要采用 queue,
    // 将每一层的入 queue ，每次将其全部 poll 出来
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgList = new LinkedList<>();
        if(root == null) {
            return avgList;
        }
        
        // 队列进行遍历
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int cnt  = queue.size();// 该层的节点数
            double sum = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            avgList.add(sum / cnt);// 不会除 0 因为 while 判断不为 空 
        }
        return avgList;
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
