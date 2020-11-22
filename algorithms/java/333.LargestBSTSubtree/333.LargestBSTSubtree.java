package Test_1;
/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-22 13:05:03
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-22 21:07:28
 * @@Email: 8211180515@csu.edu.cn
 */
import java.util.Scanner;

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
public class Main {
    // dp 套路第一步：分析情况
    //      1、为左子树
    //      2、为右子树
    //      3、为当前树， 需要满足的情况是 左子树 max < root < 右子树 min
    // 因此需要知道 树的 size， 树的max 和 min
    static class ReturnType {
        public TreeNode maxBSTHead;
        public int maxBSTSize;
        public int max;
        public int min;

        public ReturnType(TreeNode maxNode, int maxSize, int max, int min) {
            this.maxBSTHead = maxNode;
            this.maxBSTSize = maxSize;
            this.max = max;
            this.min = min;
        }
    }

    private static ReturnType process(TreeNode root) {
        if(root == null) {
            return new ReturnType(null, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        // 先得到左子树
        ReturnType leftData = process(root.left);
        // 得到右子树
        ReturnType rightData = process(root.right);

        // 首先获得最小值
        int min = Math.min(root.val, leftData.min);
        int max = Math.max(root.val, rightData.max);
        // 首先考虑 一、二种情况, 分别获取 size 值
        int maxSize = Math.max(leftData.maxBSTSize, rightData.maxBSTSize);
        TreeNode maxHead = leftData.maxBSTSize > rightData.maxBSTSize ? leftData.maxBSTHead : rightData.maxBSTHead;

        // 现在判断是否存在第三种情况
        // 首先需要 左右子树最大 BST 都为他们自身
        // 且 左子树 max < root < 右子树 min
        if(leftData.maxBSTHead == root.left && rightData.maxBSTHead == root.right
                && leftData.max < root.val && rightData.min > root.val) {
            maxSize = leftData.maxBSTSize + rightData.maxBSTSize;
            maxHead = root;
        }

        // 至此完成
        return new ReturnType(maxHead, maxSize, max, min);
    }

    public static TreeNode getMaxBST(TreeNode root) {
        return process(root).maxBSTHead;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int rootValue = scan.nextInt();

        TreeNode[] nodes = new TreeNode[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new TreeNode(i);
        }

        nodes = makeTree(scan, n, nodes);

        TreeNode maxBSTNode = getMaxBST(nodes[rootValue]);

        // System.err.println(nodes[rootValue].val);
        System.out.println(maxBSTNode.val);
        scan.close();
    }

    public static TreeNode[] makeTree(Scanner scan, int n, TreeNode[] nodes) {

        for (int i = 1; i <= n; i++) {
            int father = scan.nextInt();
            int left = scan.nextInt();
            int right = scan.nextInt();

            nodes[father].left = (left == 0) ? null : nodes[left];
            nodes[father].right = (right == 0) ? null : nodes[right];
        }
        return nodes;
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



