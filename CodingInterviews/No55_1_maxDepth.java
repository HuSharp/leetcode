/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-09 18:33:04
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-09 18:34:32
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

public class No55_1_maxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}