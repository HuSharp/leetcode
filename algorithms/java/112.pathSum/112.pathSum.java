import java.util.HashSet;
import java.util.LinkedList;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-23 16:10:24
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-23 17:29:09
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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
    /*
    询问是否有从「根节点」到某个「叶子节点」经过的路径上的节点之和等于目标和。
    核心思想是对树进行一次遍历，在遍历时记录从根节点到当前节点的路径和，
    以防止重复计算。
    */
    // 采用 DFS 利用栈实现
    public boolean hasPathSum_1(TreeNode root, int sum) {
        if(root == null){
            return false;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();

        // 采用 hashSet 存储已经访问过的点
        HashSet<TreeNode> set = new HashSet<>();

        // 先把 root 入栈
        stack.push(root);
        set.add(root);

        // 每次将栈顶节点弹出后，
        // 先将该点与左节点入栈并进行 sum 判断
        // 再将该点与右节点入栈并进行 sum 判断
        int res = root.val;
        while(!stack.isEmpty()) {
            // System.out.println("aaa");
            TreeNode cur = stack.pop();// 弹出栈顶
            
            if(cur.left == null && cur.right == null) {
                System.out.println(res);
                if(res == sum) {
                    return true;
                }// 不相等
                res -= cur.val;
                continue;
            }// 至此 至少一个不为 null
            res -= cur.val;

            if(cur.left != null) {
                if(!set.contains(cur.left)) {
                    stack.push(cur);
                    res += cur.val;
                    stack.push(cur.left);
                    res += cur.left.val;
                    set.add(cur.left);

                    continue;
                }
            }
            if(cur.right != null) {
                if(!set.contains(cur.right)) {
                    stack.push(cur);
                    res += cur.val;
                    stack.push(cur.right);
                    res += cur.right.val;
                    set.add(cur.right);

                    continue;
                }
            }
            
        }
        return false;
    }

    // BFS 遍历  采用 queue
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> queueVal = new LinkedList<>();

        // 采用 hashSet 存储已经访问过的点
        HashSet<TreeNode> set = new HashSet<>();

        // 先把 root 入栈
        queue.add(root);
        queueVal.add(root.val);
        set.add(root);

        // 每次将队首节点弹出后，
        // 先将该点与左节点入栈并进行 sum 判断
        // 再将该点与右节点入栈并进行 sum 判断
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();// 弹出栈顶
            int tempVal = queueVal.poll();// 存储弹出的值， 每个弹出的值，代表该点到根节点的和
            // 每次通过此处来判断
            if(cur.left == null && cur.right == null) {
                if(tempVal == sum) {
                    return true;
                }// 不相等
                continue;
            }// 至此 至少一个不为 null
            
            if(cur.left != null) {
                if(!set.contains(cur.left)) {
                    queue.add(cur);
                    queue.add(cur.left);
                    
                    queueVal.add(tempVal);
                    queueVal.add(tempVal + cur.left.val);
                    set.add(cur.left);
                    continue;
                }
            }
            if(cur.right != null) {
                if(!set.contains(cur.right)) {
                    queue.add(cur);
                    queue.add(cur.right);
                    
                    queueVal.add(tempVal);
                    queueVal.add(tempVal + cur.right.val);
                    set.add(cur.right);
                    continue;
                }
            }
        }
        // 至此还不等
        return false;
    } 


    // 递归 DFS， 采用每次减去当前值
    public boolean hasPathSum_3(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        // 为叶节点
        if(root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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