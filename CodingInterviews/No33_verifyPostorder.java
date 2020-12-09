/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-09 16:44:31
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-09 16:59:19
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
*/
public class No33_verifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null) {
            return true;
        }
        
        return verify(postorder, 0, postorder.length-1);
    }

    // 最后一个点为根节点， 从前往后进行判断，找到第一个比根节点大的点
    // 所找到的该点之前区间便为左子树， 之后便为右子树
    private boolean verify(int[] postorder, int left, int right) {
        if(left > right) {
            return true;
        }
        int pos = left;
        while(postorder[pos] < postorder[right]) {
            pos++;
        }// 至此，找到大于当前点的第一个
        int rightTreeLeftPos = pos;
        // 将后面剩余的遍历一下， 若存在一个小于 root 的， 那么返回 false
        for ( ; pos < right; pos++) {
            if(postorder[pos] < postorder[right]) {
                return false;
            }
        }

        return verify(postorder, left, rightTreeLeftPos-1) && verify(postorder, rightTreeLeftPos, right-1);
    }
}
