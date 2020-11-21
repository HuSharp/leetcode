/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-20 11:11:29
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-20 13:02:01
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // 每个节点的 next 原本就指向 null
    public Node connect_1(Node root) {
        if(root == null) {
            return null;
        }
        connect(root.left, root.right);
        return root;
    }

    private void connect(Node node1, Node node2) {
        if(node1 == null || node2 == null) {
            return ;
        }
        node1.next = node2;
        // 先连接树上的左节点到右节点
        connect(node1.left, node1.right);
        connect(node2.left, node2.right);
        
        // 再将 左子树右节点指向右子树左节点
        connect(node1.right, node2.left);
    }
}
// @lc code=end

class Node {
    int val;
    Node left;
    Node right;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}