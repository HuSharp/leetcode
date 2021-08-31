package offer



/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func levelOrder(root *TreeNode) (res []int) {
	if root == nil {
		return
	}
	// 层次遍历
	queue := []*TreeNode{}
	queue = append(queue, root)
	for len(queue) != 0 {
		curNum := len(queue)
		for i := 0; i < curNum; i++ {
			curNode := queue[0]
			queue = queue[1:]

			res = append(res, curNode.Val)
			if curNode.Left != nil {
				queue = append(queue, curNode.Left)
			}
			if curNode.Right != nil {
				queue = append(queue, curNode.Right)
			}
		}
	}
	return
}