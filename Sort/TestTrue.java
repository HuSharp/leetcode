/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-07-07 20:43:18
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-04 16:53:03
 * @@Email: 8211180515@csu.edu.cn
 */
package Sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TestTrue {

	public static void main(String[] args) {
		
	}

	// 递归
	List<Integer> list = new LinkedList<>();
	public List<Integer> preorderTraversal_1(TreeNode root) {
		if(root == null) {
			return list;
		}

		list.add(root.val);
		preorderTraversal_1(root.left);
		preorderTraversal_1(root.right);
		
		return list;
	}

	// 中序
	// stack + 左子链
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) {
            return list;
		}
		
		stack.push(root);
		TreeNode curNode = root;
		while(!stack.isEmpty()) {
			// 首先找到左子链
			while(curNode.left != null) {
				stack.push(curNode);
				curNode = curNode.left;
			}// 开始弹出当前点， 并转向右子树
			TreeNode node = stack.pop();
			list.add(node.val);
			curNode = node.right;
		}
		return list;
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