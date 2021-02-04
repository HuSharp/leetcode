import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-26 17:08:27
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-02-04 21:47:38
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    // 递归版本
    // List<Integer> list = new LinkedList<>();
    public List<Integer> preorderTraversal_1(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return list;
    }

    // 非递归
    // 采用 stack + 每次弹出栈顶后， 先压右孩子， 再压左孩子
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();// 弹出栈顶
            list.add(cur.val);
            // 先压右孩子
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return list;
    }

}
// @lc code=end

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
