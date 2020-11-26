import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-26 20:01:48
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-26 20:17:44
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    // 由于先序是 根左右， 而后序是 左右根
    // 可以按照先序方法， 根右左， 再进行反转
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();// res
        
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // 根右左
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if(cur.left != null) {
                stack.push(cur.left);
            }
            if(cur.right != null) {
                stack.push(cur.right);
            }
        }// 至此 已经完成加载
        int size = list.size();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            res.add(list.get(size - i - 1));
        }
        return res;
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