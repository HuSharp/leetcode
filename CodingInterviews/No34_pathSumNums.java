/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-09 18:20:56
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-09 18:30:53
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

import java.util.ArrayList;
import java.util.List;

public class No34_pathSumNums {
    List<List<Integer>> res  = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        back(root, sum, new ArrayList<>());

        return res;
    }

    // 使用回溯法解决
    private void back(TreeNode root, int sum, ArrayList<Integer> array) {
        if(root == null) {
            return;
        }

        array.add(root.val);
        sum -= root.val;
        // 若为叶子节点， 且满足sum
        if(root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(array));
        } else {
            // 否则 进入到左右子树
            back(root.left, sum, array);
            back(root.right, sum, array);
        }

        // 至此判断完当前值是否满足
        array.remove(array.size() - 1);
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