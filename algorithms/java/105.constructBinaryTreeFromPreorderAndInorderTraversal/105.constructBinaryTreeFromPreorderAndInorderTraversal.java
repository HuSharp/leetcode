import java.util.HashMap;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-05 17:32:37
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-05 18:17:00
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
    // 从 pre 中按顺序找， 作为当前的 root
    // post 标记范围
    // 存放中序中各点的位置， 用来找到左右子树范围
    HashMap<Integer, Integer> inOrderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int posRoot = 0;
        // 存放中序位置
        for ( posRoot = 0; posRoot < inorder.length; posRoot++) {
            inOrderMap.put(inorder[posRoot], posRoot);
        }

        return rebuildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode rebuildTree(int[] pre, int[] pos, int preL, int inL, int inR)  {
        if(inL > inR) {
            return null;
        }
        // 取根节点
        TreeNode root = new TreeNode(pre[preL]);
        int indexRoot = inOrderMap.get(pre[preL]);
        int treeSize = indexRoot - inL;// 取左子树大小
        root.left = rebuildTree(pre, pos, preL+1, inL, indexRoot-1);
        root.right = rebuildTree(pre, pos, preL+treeSize+1, indexRoot+1, inR);

        return root;
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