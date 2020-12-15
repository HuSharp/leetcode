/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-15 23:49:15
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-15 23:49:28
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

public class No37_serialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "#!";
        }
        String res = root.val + "!";// "!" 用来隔离 1 23 和 12 3
        res += serialize(root.left);
        res += serialize(root.right);

        return res;
    }

    // 反序列化(按队列进行恢复)
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("!");
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0; i < strs.length; i++) {
            queue.add(strs[i]);
        }

        return reconPreOrder(queue);
    }

    private TreeNode reconPreOrder(Queue<String> queue) {
        String val = queue.poll();
        if(val.equals("#")) {
            return null;
        }

        TreeNode head = new TreeNode(Integer.valueOf(val));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;

    }
}
