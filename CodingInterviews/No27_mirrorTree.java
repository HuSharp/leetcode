/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-08 23:27:36
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-08 23:30:06
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

public class No27_mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        swapTree(root.left, root.right);
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

    private void swapTree(TreeNode left, TreeNode right) {
        TreeNode temp = left;
        left = right;
        right = temp;
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
