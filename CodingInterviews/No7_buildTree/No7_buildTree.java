/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-08 22:39:34
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-08 22:55:39
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

import java.util.HashMap;

public class No7_buildTree {
    HashMap<Integer, Integer> mapInOrder = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // 建立遍历中序到的当前值在先序中的位置
        // 这是由于不含重复数字
        int pos = 0;
        for (int i : inorder) {
            mapInOrder.put(i, pos++);
        }
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    // Inpos 表示中序的第 pos 个， preLeftL 表示先序的最左侧， preRightR表示先序的最右侧
    private TreeNode buildTree(int[] preorder, int[] inorder, int inPos, int preLeftL, int preRightR) {
        // 首先由 Inpos 得到当前 root 值
        int prePos = mapInOrder.get(inPos);
        TreeNode rootNode = new TreeNode(inorder[inPos]);

        int treeSize = prePos - preLeftL;
        rootNode.left = buildTree(preorder, inorder, inPos+1, preLeftL, prePos-1);
        rootNode.right = buildTree(preorder, inorder, inPos+treeSize, prePos+1, preRightR);
        
        return rootNode;
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
}
