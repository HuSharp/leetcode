import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-13 22:35:31
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-13 22:47:10
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<LinkedList<Integer>> lists = new LinkedList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();// 采用队列来层次遍历
        queue.add(root);
        boolean zig = true;
        while(!queue.isEmpty()) {

            int size = queue.size();
            Stack<Integer> stack = new Stack<>();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();// 取队首
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
                if(zig) {
                    list.add(cur.val);
                } else {
                    stack.push(cur.val);
                }
            }
            // 至此，开始把zig 或 zag 的全部倒入
            if(!zig) {
                while(!stack.isEmpty()) {
                    list.add(stack.pop());
                }
            }
            lists.add(list);
            // 清空 list
            list = new LinkedList<>();
            zig = !zig;
        }

        return lists;

    }
}

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
// @lc code=end

