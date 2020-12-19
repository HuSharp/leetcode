import java.util.HashMap;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-05 17:32:37
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-19 23:10:40
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    // post 标记范围
    // 存放中序中各点的位置， 用来找到左右子树范围
    HashMap<Integer, Integer> mapInOrder = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 建立遍历中序到的当前值在先序中的位置
        // 这是由于不含重复数字
        for (int i = 0; i < inorder.length; i++) {
            mapInOrder.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);

    }    

    // Inpos 表示中序的第 pos 个， preLeftL 表示先序的最左侧， preRightR表示先序的最右侧
    private TreeNode buildTree(int[] preorder, int[] inorder, int prePos, int inLeftL, int inRightR) {
        if(inLeftL > inRightR) {
            return null;
        }

        int inPos = mapInOrder.get(preorder[prePos]);
        TreeNode rootNode = new TreeNode(inorder[inPos]);
        int treeSize = inPos - inLeftL;

        rootNode.left = buildTree(preorder, inorder, prePos+1, inLeftL, inPos-1);
        rootNode.right = buildTree(preorder, inorder, prePos + treeSize + 1, inPos+1, inRightR);
    
        return rootNode;
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