/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-09 16:44:31
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-24 17:19:48
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

        
        int pos = left;// 初始化
        for (int i = left; i < right; i++) {
            if(postorder[i] > postorder[right]) {
                // 找到左右子树分界点
                pos = i;
                break;
            }
        }

        for (int i = pos+1; i < right; i++) {
            // 若 pos 之后的存在比 root 小的， 就返回 false
            if(postorder[i] < postorder[right]) {
                return false;
            }
        }
        
        return verify(postorder, left, pos-1) && verify(postorder, pos, right-1);
    }
}
